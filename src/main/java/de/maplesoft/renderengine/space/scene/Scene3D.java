package de.maplesoft.renderengine.space.scene;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.space.grid.Grid3D;
import de.maplesoft.renderengine.space.space3d.Vector3;

import java.util.Set;

public class Scene3D extends Scene<Vector3> {

    public Scene3D(Set<GameObject<Vector3>> gameObjects) {
        super(new Grid3D(), gameObjects);
    }

    public Scene3D() {
        this(Set.of());
    }
}
