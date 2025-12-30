package de.maplesoft.renderengine.renderobject.gameobject.defaults;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.component.Component;
import de.maplesoft.renderengine.rendergeo.shape.trigshape.impl.RFace;
import de.maplesoft.renderengine.renderobject.gameobject.component.impl.Transform2D;

import java.util.*;

public class FaceObject extends GameObject {
    public FaceObject() {
        super(List.of(
                new RFace(Transform2D.origin())),
                new TreeSet<>()
        );
    }

    public FaceObject(Transform2D transform) {
        super(List.of(
                new RFace(transform)), new TreeSet<>(Collections.singleton(transform))
        );
    }

    public FaceObject(TreeSet<Component> components) {

        RFace RFace = null;

        for(Component component : components)
            if(component instanceof Transform2D transform)
                RFace = new RFace(transform);

        if(RFace == null)
            RFace = new RFace(Transform2D.origin());

        super(
                List.of(RFace),
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
