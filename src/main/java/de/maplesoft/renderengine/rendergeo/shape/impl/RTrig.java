package de.maplesoft.renderengine.rendergeo.shape.impl;

import de.maplesoft.renderengine.rendergeo.RVector2;
import de.maplesoft.renderengine.exception.InvalidShapeException;
import de.maplesoft.renderengine.rendergeo.shape.CoreShape;
import de.maplesoft.renderengine.rendergeo.shape.RenderShape;

public class RTrig extends RenderShape implements CoreShape {

    public RTrig(RVector2[] points, RVector2 anchor) throws InvalidShapeException {
        super(points, anchor);
    }

    public RTrig(RVector2[] points) throws InvalidShapeException {
        super(points);
    }

    @Override
    public RTrig clone() {
        return new RTrig(this.clonePoints(), this.anchor.clone());
    }

    @Override
    public int getSize() {
        return 3;
    }

    public static RTrig normaltriangle() {
        return new RTrig(new RVector2[]{
                new RVector2(0, 0),
                new RVector2(0, 1),
                new RVector2(1, 1)
        });
    }
}