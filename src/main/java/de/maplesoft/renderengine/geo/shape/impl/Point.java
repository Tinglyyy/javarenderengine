package de.maplesoft.renderengine.geo.shape.impl;

import de.maplesoft.renderengine.geo.RVector;
import de.maplesoft.renderengine.geo.shape.CoreShape;
import de.maplesoft.renderengine.geo.shape.Shape;

/**
 * Single point Polygon
 */
public class Point extends Shape implements CoreShape {


    /**
     * @param location NOT CLONED
     */
    public Point(RVector location) {
        super(new RVector[]{location}, location);
    }

    public Point(RVector[] points) {
        super(points, points[0]);
    }

    @Override
    public Point clone() {
        return new Point(this.clonePoints());
    }

    @Override
    public void setAnchor(RVector location) {
        this.anchor = location;
        this.points[0] = location;
    }

    @Deprecated(forRemoval = false)
    @Override
    public RVector[] getPoints() {
        return this.points;
    }

    @Deprecated(forRemoval = false)
    @Override
    public void setPoints(RVector[] points) {
        this.points = points;
        this.anchor = points[0];
    }

    @Override
    public int getSize() {
        return 1;
    }
}
