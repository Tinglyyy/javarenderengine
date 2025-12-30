package de.maplesoft.renderengine.rendergeo.shape.trigshape.impl;

import de.maplesoft.renderengine.rendergeo.RVector2;
import de.maplesoft.renderengine.rendergeo.shape.CoreShape;
import de.maplesoft.renderengine.rendergeo.shape.impl.RTrig;
import de.maplesoft.renderengine.rendergeo.shape.trigshape.Trigshape;
import de.maplesoft.renderengine.renderobject.gameobject.component.impl.Transform2D;
import de.maplesoft.renderengine.space.space2d.Vector2;

public class RFace extends Trigshape implements CoreShape {
    public RFace(Transform2D transform) {
        super(new RTrig[2], transform);

        Vector2 s = transform.getScale();

        RTrig t1 = RTrig.normaltriangle();

        RTrig t2 = t1.clone();
        t2.mirrorOrigin();
        t2.move(new RVector2(100, 100));

        t1.scale(100);

        t2.scale(100);

        this.transform = transform;

        this.rTrigs = new RTrig[] { t1, t2 };

    }

}
