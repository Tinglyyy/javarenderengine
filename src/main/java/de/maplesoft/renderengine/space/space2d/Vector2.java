package de.maplesoft.renderengine.space.space2d;

import de.maplesoft.renderengine.rendergeo.RVector2;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Vector2 {
    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public Vector2(RVector2 vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    @Override
    public Vector2 clone() {
        return new Vector2(this);
    }

    public Vector2 add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    public Vector2 addX(double x) {
        this.x += x;
        return this;
    }

    public Vector2 addY(double y) {
        this.y += y;
        return this;
    }

    public Vector2 subtract(Vector2 other) {
        this.x -= other.x;
        this.y -= other.y;
        return this;
    }

    public Vector2 subtractX(double x) {
        this.x -= x;
        return this;
    }

    public Vector2 subtractY(double y) {
        this.y -= y;
        return this;
    }

    /**
     * scalar multiply
     */
    public Vector2 multiply(double r) {
        this.x *= r;
        this.y *= r;
        return this;
    }

    /**
     * cross multiply
     */
    public Vector2 multiply(Vector2 other) {
        this.x *= other.y;
        this.y *= other.x;
        return this;
    }

    /**
     * scalar divide
     */
    public Vector2 divide(double r) {
        this.x /= r;
        this.y /= r;
        return this;
    }

    /**
     * cross divide
     */
    public Vector2 divide(Vector2 other) {
        this.x /= other.y;
        this.y /= other.x;
        return this;
    }

    /**
     * Calculate angle to the X-axis
     * @return angle in degrees
     */
    public double getGraphAngleX() {
        return Math.asin(this.y / this.getMagnitude()) * 180/Math.PI;
    }

    /**
     * Calculate angle to the Y-axis
     * @return angle in degrees
     */
    public double getGraphAngleY() {
        return Math.asin(this.x / this.getMagnitude()) * 180/Math.PI;
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Vector2 normalize() {
        double mag = this.getMagnitude();

        return this.multiply(1/mag);
    }
    public double calculateDistance(Vector2 other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public static Vector2 zero() {
        return new Vector2(0,0);
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vector2 v)
            return v.x == this.x && v.y == this.y;
        return false;
    }
}
