package de.maplesoft.renderengine.rendergeo;

import de.maplesoft.renderengine.space.space3d.Vector3;
import lombok.Getter;
import lombok.Setter;

/**
 * No need for 3d render vectors
 */

@Deprecated(forRemoval = true)
@Getter
@Setter
public class RVector3 {
    private int x;
    private int y;
    private int z;

    public RVector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public RVector3(RVector3 vector) {
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;
    }

    public RVector3(Vector3 vector) {
        this.x = (int) vector.getX();
        this.y = (int) vector.getY();
        this.z = (int) vector.getZ();
    }

    @Override
    public RVector3 clone() {
        return new RVector3(this);
    }

    public RVector3 add(RVector3 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        return this;
    }

    public RVector3 addX(int x) {
        this.x += x;
        return this;
    }

    public RVector3 addY(int y) {
        this.y += y;
        return this;
    }

    public RVector3 addZ(int z) {
        this.z += z;
        return this;
    }

    public RVector3 subtract(RVector3 other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
        return this;
    }

    public RVector3 subtractX(int x) {
        this.x -= x;
        return this;
    }

    public RVector3 subtractY(int y) {
        this.y -= y;
        return this;
    }

    public RVector3 subtractZ(int z) {
        this.z -= z;
        return this;
    }


    /**
     * scalar multiply
     */
    public RVector3 multiply(int r) {
        this.x *= r;
        this.y *= r;
        this.z *= r;
        return this;
    }

    /**
     * cross multiply
     */
    public RVector3 multiply(RVector3 other) {
        this.x = this.y * other.z - other.y * this.z;
        this.y = this.z * other.x - other.z * this.x;
        this.z = this.x * other.y - this.y * other.z;

        return this;
    }

    /**
     * scalar divide
     */
    public RVector3 divide(int r) {
        this.x /= r;
        this.y /= r;
        this.z /= r;
        return this;
    }

    /**
     * cross divide
     */
    public RVector3 divide(RVector3 other) {
        this.x = this.y / other.z - other.y / this.z;
        this.y = this.z / other.x - other.z / this.x;
        this.z = this.x / other.y - this.y / other.z;

        return this;
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public RVector3 normalize() {
        double mag = this.getMagnitude();

        return this.multiply((int) (1/mag));
    }

    public double calculateDistance(RVector3 other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2));
    }

    public static RVector3 zero() {
        return new RVector3(0,0,0);
    }


    @Override
    public String toString() {
        return STR."{x=\{this.x},y=\{this.y},z=\{this.z}}";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RVector3 v)
            return v.x == this.x && v.y == this.y && v.z == this.z;
        else if(obj instanceof Vector3 v)
            return v.getX() == this.x && v.getY() == this.y && v.getZ() == this.z;
        return false;
    }
}
