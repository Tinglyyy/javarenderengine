package de.maplesoft.renderengine.space.space3d;

import de.maplesoft.renderengine.space.polygon.Polygon;
import de.maplesoft.renderengine.space.util.VectorUtils;
import lombok.Getter;
import lombok.Setter;

public class Polygon3 implements Polygon<Vector3> {
    @Getter @Setter
    protected Vector3[] vertices;

    @Override
    public void scale(double scalar) {
        Vector3 anchor = this.getAnchor();

        for(Vector3 vector : this.vertices) {
            vector.subtract(anchor)
                    .multiply(scalar);
        }
    }

    @Override
    public Vector3 getAnchor() {
        return VectorUtils.average(this.vertices);
    }

    @Override
    public void translate(Vector3 vector) {
        for(Vector3 vertex : this.vertices)
            vertex.add(vector);
    }


    public Polygon3(Vector3[] vertices) {
        this.vertices = vertices;
    }
}
