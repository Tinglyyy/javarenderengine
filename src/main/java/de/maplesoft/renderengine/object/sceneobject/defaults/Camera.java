package de.maplesoft.renderengine.object.sceneobject.defaults;

import de.maplesoft.renderengine.geo.shape.trigshape.Trigshape;
import de.maplesoft.renderengine.object.gameobject.GameObject;
import de.maplesoft.renderengine.object.sceneobject.SceneObject;
import de.maplesoft.renderengine.space.space3d.Vector3;
import lombok.Getter;
import lombok.Setter;

public class Camera extends SceneObject {

    @Getter @Setter
    private double zoom;

    public Camera() {
        this(Vector3.zero(), 1);
    }
    public Camera(Vector3 location, double zoom) {
        this.location = location;
        this.zoom = zoom;
    }

    public boolean isOnScreen(GameObject gameObject) {
        for(Trigshape trigshape : gameObject.getTrigshapes()) {
        }
    }

    @Override
    public SceneObject clone() {
        return new Camera(this.location, this.zoom);
    }
}
