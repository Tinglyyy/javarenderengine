package de.maplesoft.renderengine.space.space2d;

import de.maplesoft.renderengine.space.polygon.Polygon;
import de.maplesoft.renderengine.space.util.VectorUtils;
import lombok.Getter;
import lombok.Setter;

public class Polygon2 implements Polygon<Vector2> {
    @Getter
    @Setter
    protected Vector2[] vertices;

    @Override
    public void scale(double scalar) {
        Vector2 anchor = this.getAnchor();

        for(Vector2 vector : this.vertices) {
            vector.subtract(anchor)
                    .multiply(scalar);
        }
    }

    @Override
    public Vector2 getAnchor() {
        return VectorUtils.average(this.vertices);
    }

    @Override
    public void translate(Vector2 vector) {
        for(Vector2 vertex : this.vertices)
            vertex.add(vector);
    }


    public Polygon2(Vector2[] vertices) {
        this.vertices = vertices;
    }
}
