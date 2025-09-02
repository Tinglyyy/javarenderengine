package de.maplesoft.renderengine.geo.shape.trigshape.impl;

import de.maplesoft.renderengine.geo.RVector;
import de.maplesoft.renderengine.geo.shape.CoreShape;
import de.maplesoft.renderengine.geo.shape.impl.Triangle;
import de.maplesoft.renderengine.geo.shape.trigshape.Trigshape;
import de.maplesoft.renderengine.object.gameobject.component.impl.Transform2D;
import de.maplesoft.renderengine.space.space2d.Vector2;

public class Face extends Trigshape implements CoreShape {
    public Face(Transform2D transform) {
        super(new Triangle[2], transform);

        Vector2 s = transform.getScale();

        Triangle t1 = Triangle.normaltriangle();

        Triangle t2 = t1.clone();
        t2.mirrorOrigin();
        t2.move(new RVector(100, 100));

        t1.scale(100);

        t2.scale(100);

        this.transform = transform;

        this.triangles = new Triangle[] { t1, t2 };

    }

}
