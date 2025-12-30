package de.maplesoft.renderengine.renderobject.gameobject.defaults;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.component.Components;
import de.maplesoft.renderengine.space.space3d.Vector3;

public class EmptyGameObject3D extends GameObject<Vector3> {
    public EmptyGameObject3D(Components components, String name) {
        super(components, name);
    }

    public EmptyGameObject3D(String name) {
        this(Components.ofName(name), name);
    }

    @Override
    public GameObject<Vector3> clone() {
        return null;
    }
}
