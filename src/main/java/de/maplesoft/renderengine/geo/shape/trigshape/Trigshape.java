package de.maplesoft.renderengine.geo.shape.trigshape;

import de.maplesoft.renderengine.geo.shape.impl.Triangle;
import de.maplesoft.renderengine.object.gameobject.component.impl.Transform2D;
import lombok.Getter;

@Getter
public abstract class Trigshape {
    protected Triangle[] triangles;

    protected Transform2D transform;

    protected Trigshape(Triangle[] triangles, Transform2D transform) {
        this.triangles = triangles;

        this.transform = transform;
    }
}
