package de.maplesoft.renderengine.rendergeo.shape.impl;

import de.maplesoft.renderengine.rendergeo.RVector2;
import de.maplesoft.renderengine.rendergeo.shape.CoreShape;
import de.maplesoft.renderengine.rendergeo.shape.RenderShape;

/**
 * Single point Polygon
 */
public class RPoint extends RenderShape implements CoreShape {


    /**
     * @param location NOT CLONED
     */
    public RPoint(RVector2 location) {
        super(new RVector2[]{location}, location);
    }

    public RPoint(RVector2[] points) {
        super(points, points[0]);
    }

    @Override
    public RPoint clone() {
        return new RPoint(this.clonePoints());
    }

    @Override
    public void setAnchor(RVector2 location) {
        this.anchor = location;
        this.points[0] = location;
    }

    @Deprecated(forRemoval = false)
    @Override
    public RVector2[] getPoints() {
        return this.points;
    }

    @Deprecated(forRemoval = false)
    @Override
    public void setPoints(RVector2[] points) {
        this.points = points;
        this.anchor = points[0];
    }

    @Override
    public int getSize() {
        return 1;
    }
}
