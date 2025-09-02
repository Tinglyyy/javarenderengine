package de.maplesoft.renderengine.geo.shape.impl;

import de.maplesoft.renderengine.geo.RVector;
import de.maplesoft.renderengine.exception.InvalidShapeException;
import de.maplesoft.renderengine.geo.shape.CoreShape;
import de.maplesoft.renderengine.geo.shape.Shape;

public class Triangle extends Shape implements CoreShape {

    public Triangle(RVector[] points, RVector anchor) throws InvalidShapeException {
        super(points, anchor);
    }

    public Triangle(RVector[] points) throws InvalidShapeException {
        super(points);
    }

    @Override
    public Triangle clone() {
        return new Triangle(this.clonePoints(), this.anchor.clone());
    }

    @Override
    public int getSize() {
        return 3;
    }

    public static Triangle normaltriangle() {
        return new Triangle(new RVector[]{
                new RVector(0, 0),
                new RVector(0, 1),
                new RVector(1, 1)
        });
    }
}