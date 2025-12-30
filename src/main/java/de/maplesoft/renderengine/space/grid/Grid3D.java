package de.maplesoft.renderengine.space.grid;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.component.impl.Transform3D;
import de.maplesoft.renderengine.space.space3d.Vector3;
import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


// TODO: make interface and implement 2d and 3d
public class Grid3D implements Grid<Vector3> {
    @Getter
    private double scale = 1;

    Map<Vector3, Set<GameObject<Vector3>>> gridObjects = new HashMap<>();

    public Grid3D() {

    }

    public Grid3D(double scale) {
        this.scale = scale;
    }


    @Override
    public void placeObjects(Vector3 location, GameObject<Vector3>... objects) {
        this.placeObjects(location, Set.of(objects));
    }

    @Override
    public void placeObjects(GameObject<Vector3>... objects) {
        for(GameObject<Vector3> gameObject : objects)
            this.placeObject(gameObject);
    }

    @Override
    public void placeObjects(Collection<GameObject<Vector3>> objects) {
        for(GameObject<Vector3> gameObject : objects)
            this.placeObject(gameObject);
    }

    @Override
    public void placeObjects(Vector3 location, Set<GameObject<Vector3>> objects) {
        Set<GameObject<Vector3>> gameObjects = this.gridObjects.get(location);

        if(gameObjects == null)
            gameObjects = Set.of();

        gameObjects.addAll(objects);

        this.gridObjects.replace(location, objects);
    }

    public void placeObject(Vector3 location, GameObject<Vector3> gameObject) {
        this.placeObjects(location, Set.of(gameObject));
    }

    public void placeObject(GameObject<Vector3> gameObject) {
        this.placeObject(gameObject.getComponent(Transform3D.class).getAnchor(), gameObject);
    }

//    public Set<GameObject> getObjects(Vector3 location) {
//        return this.getObjects(new RVector3(location));
//    }

    public Set<GameObject<Vector3>> getObjects(Vector3 location) {
        for(Vector3 v : this.gridObjects.keySet()) {
            if (v.equals(location))
                return this.gridObjects.get(v);
        }

        return Set.of();
    }


}
