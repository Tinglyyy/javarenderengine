package de.maplesoft.renderengine.rendergeo.shape.impl;

import de.maplesoft.renderengine.rendergeo.RVector2;
import de.maplesoft.renderengine.exception.InvalidShapeException;
import de.maplesoft.renderengine.rendergeo.shape.RenderShape;

public class RPol extends RenderShape {
    public RPol(RVector2[] points, RVector2 anchor) throws InvalidShapeException {
        super(points, anchor);
    }

    public RPol(RVector2[] points) throws InvalidShapeException {
        super(points);
    }

    @Override
    public RPol clone() {
        return new RPol(this.clonePoints(), this.anchor.clone());
    }

    @Override
    public int getSize() {
        return 0;
    }
}
