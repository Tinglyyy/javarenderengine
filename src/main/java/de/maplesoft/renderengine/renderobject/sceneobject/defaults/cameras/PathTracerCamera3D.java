package de.maplesoft.renderengine.renderobject.sceneobject.defaults.cameras;

import de.maplesoft.renderengine.exception.InvalidComponentException;
import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.component.impl.Mesh3D;
import de.maplesoft.renderengine.renderobject.gameobject.component.impl.Transform3D;
import de.maplesoft.renderengine.renderobject.sceneobject.SceneObject;
import de.maplesoft.renderengine.renderobject.sceneobject.defaults.Camera;
import de.maplesoft.renderengine.space.polygon.Polygon;
import de.maplesoft.renderengine.space.polygon.Polygons;
import de.maplesoft.renderengine.space.scene.Scene;
import de.maplesoft.renderengine.space.space3d.Polygon3;
import de.maplesoft.renderengine.space.space3d.Polygons3;
import de.maplesoft.renderengine.space.space3d.Vector3;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * A 3D camera working with the path tracer concept:
 * on render call, a vector is instantiated that takes a step of length <code>stepDistance</code> orthogonally to the camera.
 * Each render step for the given <code>renderDistance</code> amount of steps.
 * After every step, all scene objects' meshes around the vector that are within the radius of <code>fov</code> (scaled by the current step distance)
 * are located, and on screen polygons are queued for rendering.
 */
public class PathTracerCamera3D extends SceneObject implements Camera<Vector3> {

    @Getter @Setter
    private Vector3 pathVector = null;

    @Getter @Setter
    private double fov;

    @Getter @Setter
    private int renderDistance;

    @Getter @Setter
    private double stepDistance;

    private double currentDistance = 0;

    private Collection<GameObject<Vector3>> loadable = null;

    public PathTracerCamera3D() {
        this(Vector3.zero(), 10, 100, 1);
    }
    public PathTracerCamera3D(Vector3 location, double fov, int renderDistance, double stepDistance) {
        this.location = location;
        this.fov = fov;
        this.renderDistance = renderDistance;
        this.stepDistance = stepDistance;
    }


    @Override
    public boolean isOnScreen(GameObject<Vector3> gameObject) {
        if (this.pathVector == null)
            return false;

        Transform3D transform = gameObject.getComponent(Transform3D.class, null);

        if(transform == null)
            return false;

        Mesh3D mesh = gameObject.getComponent(Mesh3D.class, Mesh3D.singleton(transform.getPosition()));

        for(Polygon<Vector3> polygon : mesh.getPolygons())
            for(Vector3 vector : polygon.getVertices())
                if (this.pathVector.calculateDistance(vector) <= this.fov * this.currentDistance)
                    return true;


        return false;
    }

    @Override
    public Polygon<Vector3> getOnScreen(Polygon<Vector3> polygon) {
        if (this.pathVector == null)
            return null;

        List<Vector3> onScreenVertices = new ArrayList<>();

        for(Vector3 vertex : polygon.getVertices())
            if(this.pathVector.calculateDistance(vertex) <= this.fov * this.currentDistance)
                onScreenVertices.add(vertex);

        return new Polygon3(onScreenVertices.toArray(new Vector3[0]));
    }

    @Override
    public void render(Scene<Vector3> scene) {
        this.pathVector = this.location.clone();

        this.currentDistance = 0;

        this.loadable = scene.getGameObjects().values();

        Vector3 step = this.pathVector.clone().normalize().multiply(this.stepDistance);

        step.rotate(this.rotation);

        for(int s = 1; s <= this.renderDistance; s++) {

            this.currentDistance += this.stepDistance;

            this.pathVector.add(step);

            this.stepRender();
        }

        this.pathVector = null;
    }

    private void stepRender() {
        Set<GameObject<Vector3>> traced = new HashSet<>();

        for(GameObject<Vector3> gameObject : this.loadable) {
            Polygons<Vector3> polygons = new Polygons3();

            Mesh3D mesh;

            try {
                mesh = gameObject.getComponent(Mesh3D.class);
            } catch (InvalidComponentException ignored) {
                continue;
            }

            for(Polygon<Vector3> polygon : mesh.getPolygons()) {
                Polygon<Vector3> onScreen = this.getOnScreen(polygon);

                if(onScreen != null)
                    polygons.add(onScreen);
            }

            if(!polygons.isEmpty()) {
                //TODO: Render

                traced.add(gameObject);
            }
        }

        this.loadable.removeAll(traced);
    }

    @Override
    public SceneObject clone() {
        return new PathTracerCamera3D(this.location, this.fov, this.renderDistance, this.stepDistance);
    }
}
