package de.maplesoft.renderengine.geo;

import lombok.Getter;
import lombok.Setter;

/**
 * Render vector
 */
@Getter @Setter
public class RVector {
    private int x;
    private int y;

    public RVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public RVector(RVector rVector) {
        this.x = rVector.x;
        this.y = rVector.y;
    }

    @Override
    public RVector clone() {
        return new RVector(this);
    }

    public RVector addX(int x) {
        this.x += x;
        return this;
    }

    public RVector addY(int y) {
        this.y += y;
        return this;
    }

    public RVector add(RVector other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    public RVector subtract(RVector other) {
        this.x -= other.x;
        this.y -= other.y;
        return this;
    }

    /**
     * scalar multiply
     */
    public RVector multiply(int r) {
        this.x *= r;
        this.y *= r;
        return this;
    }

    /**
     * cross multiply
     */
    public RVector multiply(RVector other) {
        this.x *= other.y;
        this.y *= other.x;
        return this;
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public double calculateDistance(RVector other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{x=")
                .append(this.x)
                .append(",y=")
                .append(this.y)
                .append("}");

        return builder.toString();
    }
}
