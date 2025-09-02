package de.maplesoft.renderengine.space.space3d;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Vector3 {
    private double x;
    private double y;
    private double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector3 vector) {
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;
    }

    @Override
    public Vector3 clone() {
        return new Vector3(this);
    }

    public Vector3 addX(double x) {
        this.x += x;
        return this;
    }

    public Vector3 addY(double y) {
        this.y += y;
        return this;
    }

    public Vector3 addZ(double z) {
        this.z += z;
        return this;
    }


    public Vector3 add(Vector3 other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    /**
     * scalar multiply
     */
    public Vector3 multiply(double r) {
        this.x *= r;
        this.y *= r;
        this.z *= z;
        return this;
    }

    /**
     * cross multiply
     */
    public Vector3 multiply(Vector3 other) {
        this.x = this.y * other.z - other.y * this.z;
        this.y = this.z * other.x - other.z * this.x;
        this.z = this.x * other.y - this.y * other.z;

        return this;
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public double calculateDistance(Vector3 other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2));
    }

    public static Vector3 zero() {
        return new Vector3(0,0,0);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{x=")
                .append(this.x)
                .append(",y=")
                .append(this.y)
                .append(",z=")
                .append(this.z)
                .append("}");

        return builder.toString();
    }

}
