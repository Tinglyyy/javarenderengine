package de.maplesoft.renderengine.rendergeo;

import de.maplesoft.renderengine.space.space2d.Vector2;
import lombok.Getter;
import lombok.Setter;

/**
 * Render vector
 */
@Getter @Setter
public class RVector2 {
    private int x;
    private int y;

    public RVector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public RVector2(RVector2 rVector2) {
        this.x = rVector2.x;
        this.y = rVector2.y;
    }

    public RVector2(Vector2 vector) {
        this.x = (int) vector.getX();
        this.y = (int) vector.getY();
    }

    @Override
    public RVector2 clone() {
        return new RVector2(this);
    }

    public RVector2 addX(int x) {
        this.x += x;
        return this;
    }

    public RVector2 addY(int y) {
        this.y += y;
        return this;
    }

    public RVector2 add(RVector2 other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    public RVector2 subtract(RVector2 other) {
        this.x -= other.x;
        this.y -= other.y;
        return this;
    }

    /**
     * scalar multiply
     */
    public RVector2 multiply(int r) {
        this.x *= r;
        this.y *= r;
        return this;
    }

    /**
     * cross multiply
     */
    public RVector2 multiply(RVector2 other) {
        this.x *= other.y;
        this.y *= other.x;
        return this;
    }

    public static RVector2 zero() {
        return new RVector2(0, 0);
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public double calculateDistance(RVector2 other) {
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RVector2 v)
            return v.x == this.x && v.y == this.y;
        return false;
    }
}
