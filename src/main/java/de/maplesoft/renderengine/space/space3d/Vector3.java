package de.maplesoft.renderengine.space.space3d;

import de.maplesoft.renderengine.space.util.MathUtils;
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

//    public Vector3(RVector3 vector) {
//        this.x = vector.getX();
//        this.y = vector.getY();
//        this.z = vector.getZ();
//    }

    @Override
    public Vector3 clone() {
        return new Vector3(this);
    }

    public Vector3 add(Vector3 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        return this;
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

    public Vector3 subtract(Vector3 other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
        return this;
    }

    public Vector3 subtractX(double x) {
        this.x -= x;
        return this;
    }

    public Vector3 subtractY(double y) {
        this.y -= y;
        return this;
    }

    public Vector3 subtractZ(double z) {
        this.z -= z;
        return this;
    }


    /**
     * scalar multiply
     */
    public Vector3 multiply(double r) {
        this.x *= r;
        this.y *= r;
        this.z *= r;
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

    /**
     * scalar divide
     */
    public Vector3 divide(double r) {
        this.x /= r;
        this.y /= r;
        this.z /= r;
        return this;
    }

    /**
     * cross divide
     */
    public Vector3 divide(Vector3 other) {
        this.x = this.y / other.z - other.y / this.z;
        this.y = this.z / other.x - other.z / this.x;
        this.z = this.x / other.y - this.y / other.z;

        return this;
    }

    /**
     * Rotate by given rotation
     */
    public Vector3 rotate(Rot3 rotation) {
        Rot3 angles = this.getGraphAngles();

        double mag = this.getMagnitude();

        angles.add(rotation);

        this.x = mag * MathUtils.sin(angles.getAlpha());
        this.y = mag * MathUtils.sin(angles.getBeta());
        this.z = mag * MathUtils.sin(angles.getGamma());

        return this;
    }

    /**
     * Calculate angles to all 3d planes
     * @return angles in degrees
     */
    public Rot3 getGraphAngles() {
        return new Rot3(
          this.getGraphAngleXY(),
          this.getGraphAngleXZ(),
          this.getGraphAngleYZ()
        );
    }

    /**
     * Calculate angle to XY-plane
     * @return angle in degrees
     */
    public double getGraphAngleXY() {
        return Math.asin(this.y / this.getXYHypotenuse()) * MathUtils.RAD2ANGLES;
    }

    /**
     * Calculate angle to YZ-plane
     * @return angle in degrees
     */
    public double getGraphAngleYZ() {
        return Math.asin(this.y / this.getYZHypotenuse()) * MathUtils.RAD2ANGLES;
    }

    /**
     * Calculate angle to XZ-plane
     * @return angle in degrees
     */
    public double getGraphAngleXZ() {
        return Math.asin(this.x / this.getXZHypotenuse()) * MathUtils.RAD2ANGLES;
    }

    private double getYZHypotenuse() {
        return Math.sqrt(Math.pow(this.z, 2) + Math.pow(this.y, 2));
    }

    private double getXZHypotenuse() {
        return Math.sqrt(Math.pow(this.z, 2) + Math.pow(this.x, 2));
    }

    private double getXYHypotenuse() {
        return Math.sqrt(Math.pow(this.y, 2) + Math.pow(this.x, 2));
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public Vector3 getConnectingOrthogonal() {
        Rot3 rotation = this.getGraphAngles();

        return this.clone().rotate(new Rot3(90, 90, 90));
    }

    /**
     * Turn this into a vector with magnitude = 1
     */
    public Vector3 normalize() {
        double mag = this.getMagnitude();

        return this.divide(mag);
    }

    public double calculateDistance(Vector3 other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2));
    }

    public static Vector3 zero() {
        return new Vector3(0,0,0);
    }


    @Override
    public String toString() {
        return STR."{x=\{this.x},y=\{this.y},z=\{this.z}}";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vector3 v)
            return v.x == this.x && v.y == this.y && v.z == this.z;
//        else if(obj instanceof RVector3 v)
//            return v.getX() == this.x && v.getY() == this.y && v.getZ() == this.z;
        return false;
    }

}
