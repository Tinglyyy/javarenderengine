package de.maplesoft.renderengine.rendergeo.shape;

import de.maplesoft.renderengine.rendergeo.RVector2;
import de.maplesoft.renderengine.exception.InvalidShapeException;
import de.maplesoft.renderengine.rendergeo.shape.impl.RTrig;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;


public abstract class RenderShape {
    @Getter
    protected RVector2[] points;

    @Getter
    protected double rotation;

    /**
     * Radius of each point to the Anchor point
     */
    protected double[] radiuses;

    /**
     * Clockwise rotation around the Anchor point of each point
     */
    protected double[] radians;

    @Getter @Setter
    protected RVector2 anchor;

    protected RenderShape(RVector2[] points) {
        this.points = points;

        this.validCheck();

        this.anchor = calculateAnchor(points);

        this.radiuses = calculateRadiuses(this.points, this.anchor);

        this.radians = calculateRadians(this.points, this.anchor, this.radiuses);
    }

    @Override
    public abstract RenderShape clone();

    protected RenderShape(RVector2[] points, RVector2 anchor) throws InvalidShapeException {
        this(points);
        this.anchor = anchor;
    }

    /**
     * Needed since [ArrayType].clone() only clones the pointer and not the elements
     * @return clone array of points
     */
    protected RVector2[] clonePoints() {
        RVector2[] cloned = new RVector2[this.points.length];

        for(int i = 0; i < this.points.length; i++)
            cloned[i] = this.points[i].clone();

        return cloned;
    }

    public void setPoints(RVector2[] points) {
        this.validCheck();

        this.points = points;
    }

    public abstract int getSize();

    public Polygon toSwingPolygon() {
        int[] x = new int[this.getSize()];
        int[] y = new int[this.getSize()];

        for(int i = 0; i < this.getSize(); i++) {
            x[i] = this.points[i].getX();
            y[i] = this.points[i].getY();
        }

        return new Polygon(x, y, this.getSize());
    }

    private void validCheck() {
        int size = this.getSize();
        if(size > 0 && this.points.length != size)
            throw new InvalidShapeException(RTrig.class, this.points.length, size);
    }

    public void move(RVector2 vector) {
        for(RVector2 point : this.points)
            point.add(vector);

        this.anchor.add(vector);
    }

    public void moveX(int x) {
        for(RVector2 point : this.points)
            point.addX(x);

        this.anchor.addX(x);
    }

    public void moveY(int y) {
        for(RVector2 point : this.points)
            point.addY(y);

        this.anchor.addY(y);
    }

    public void rotate(double r) {
        this.rotation += r;

        if(Math.abs(this.rotation) > 2)
            this.rotation -= 2;

        for(int i = 0; i < this.getSize(); i++) {
            this.points[i] = this.rotate(this.radians[i], this.radiuses[i]);
        }
    }

    public void scale(int s) {
        for(int i = 0; i < this.getSize(); i++) {
            this.radiuses[i] *= s;

            this.points[i].add(
                    this.points[i].clone()
                    .subtract(this.anchor)
                    .multiply(s)
            );

        }
    }

    public void mirrorOrigin() {
        for(RVector2 point : points) {
            point.setX(-point.getX());
            point.setY(-point.getY());
        }
    }

    public void mirrorAboutX() {
        for(RVector2 point : points)
            point.setY(-point.getY());
    }

    public void mirrorAboutY() {
        for(RVector2 point : points)
            point.setX(-point.getX());
    }

    private RVector2 rotate(double radiants, double radius) {
        int x = (int) (radius * Math.sin(this.rotation * Math.PI + radiants));
        int y = (int) (radius * Math.cos(this.rotation * Math.PI + radiants));

        RVector2 originRotation = new RVector2(x, y);

        return this.anchor.clone().add(originRotation);
    }

    private static RVector2 calculateAnchor(RVector2[] points) {
        int sumX = 0, sumY = 0;

        for(RVector2 point : points) {
            sumX += point.getX();
            sumY += point.getY();
        }

        sumX /= points.length;
        sumY /= points.length;

        return new RVector2(sumX, sumY);
    }

    private static double[] calculateRadiuses(RVector2[] points, RVector2 anchor) {
        double[] radiuses = new double[points.length];

        for(int i = 0; i < points.length; i++)
            radiuses[i] = points[i].calculateDistance(anchor);

        return radiuses;

    }

    private static double[] calculateRadians(RVector2[] points, RVector2 anchor, double[] radiuses) {
        double[] radiants = new double[points.length];

        for(int i = 0; i < points.length; i++) {
            RVector2 point = points[i];

            int dx = anchor.getX() - point.getX();
            int dy = anchor.getY() - point.getY();

            double c = 0;

            if(dx < 0) {
                if (dy >= 0)
                    c += 1;

                c += 0.5;
            }

            if(dy < 0)
                c += 0.5;

            c *= Math.PI;

            radiants[i] = Math.asin(Math.abs(dx)/radiuses[i]) + c;
        }

        return radiants;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getClass().getSimpleName());

        builder.append("={points=[");

        for(RVector2 point : this.points)
            builder.append(point.toString()).append(',');

        builder.append("],anchor=").append(this.anchor).append("}");

        return builder.toString();
    }

}
