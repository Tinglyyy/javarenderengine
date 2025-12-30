package de.maplesoft.renderengine.space.space3d;

import lombok.Getter;

public class VectorPlane3 {
    @Getter
    private Vector3 vector, normal;

    // E: (x - p) * n = 0
    public VectorPlane3(Vector3 vector, Vector3 normal) {
        this.vector = vector;
        this.normal = normal;
    }

    // E: x = a + r * r1 + s * r2
    public VectorPlane3(Vector3 vector, Vector3 r1, Vector3 r2) {
        this.vector = vector;
        this.normal = r1.multiply(r2);
    }

    public boolean isOnPlane(Vector3 vector) {
        Vector3 v1 = vector.clone()
                .subtract(this.vector.clone());

        double x = this.normal.getX() * v1.getX();
        double y = this.normal.getY() * v1.getY();
        double z = this.normal.getZ() * v1.getZ();

        return x + y + z == 0;
    }

    public boolean isOnPlane(Vector3 vector, double radius) {
        Vector3 v1 = vector.clone()
                .subtract(this.vector.clone());

        double x = this.normal.getX() * v1.getX();
        double y = this.normal.getY() * v1.getY();
        double z = this.normal.getZ() * v1.getZ();

        return x + y + z == 0 && this.normal.calculateDistance(vector) <= radius;
    }

    public VectorPlane3 clone() {
        return new VectorPlane3(this.vector.clone(), this.normal.clone());
    }

    public VectorPlane3 scale(double scalar) {
        this.normal.multiply(scalar);

        return this;
    }

    public double getScale() {
        return this.normal.getMagnitude();
    }
}
