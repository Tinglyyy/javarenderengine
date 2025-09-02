package de.maplesoft.renderengine.object.gameobject.defaults;

import de.maplesoft.renderengine.object.gameobject.GameObject;
import de.maplesoft.renderengine.object.gameobject.component.Component;
import de.maplesoft.renderengine.geo.shape.trigshape.impl.Face;
import de.maplesoft.renderengine.object.gameobject.component.impl.Transform2D;

import java.util.*;

public class FaceObject extends GameObject {
    public FaceObject() {
        super(List.of(
                new Face(Transform2D.origin())),
                new TreeSet<>()
        );
    }

    public FaceObject(Transform2D transform) {
        super(List.of(
                new Face(transform)), new TreeSet<>(Collections.singleton(transform))
        );
    }

    public FaceObject(TreeSet<Component> components) {

        Face face = null;

        for(Component component : components)
            if(component instanceof Transform2D transform)
                face = new Face(transform);

        if(face == null)
            face = new Face(Transform2D.origin());

        super(
                List.of(face),
                components
        );
    }

    @Override
    public GameObject clone() {
        return new FaceObject(this.components);
    }

    @Override
    public void reload() {

    }

    @Override
    public void reloadScripts() {

    }
}
