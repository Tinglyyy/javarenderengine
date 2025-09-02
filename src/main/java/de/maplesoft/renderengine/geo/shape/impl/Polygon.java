package de.maplesoft.renderengine.geo.shape.impl;

import de.maplesoft.renderengine.geo.RVector;
import de.maplesoft.renderengine.exception.InvalidShapeException;
import de.maplesoft.renderengine.geo.shape.Shape;

public class Polygon extends Shape {
    public Polygon(RVector[] points, RVector anchor) throws InvalidShapeException {
        super(points, anchor);
    }

    public Polygon(RVector[] points) throws InvalidShapeException {
        super(points);
    }

    @Override
    public Polygon clone() {
        return new Polygon(this.clonePoints(), this.anchor.clone());
    }

    @Override
    public int getSize() {
        return 0;
    }
}
