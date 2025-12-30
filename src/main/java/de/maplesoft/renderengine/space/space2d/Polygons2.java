package de.maplesoft.renderengine.space.space2d;

import de.maplesoft.renderengine.space.polygon.Polygon;
import de.maplesoft.renderengine.space.polygon.Polygons;
import de.maplesoft.renderengine.space.util.VectorUtils;

import java.util.ArrayList;
import java.util.List;

public class Polygons2 extends Polygons<Vector2> {

    @Override
    public void scale(double scalar) {
        Vector2 average = this.average();

        for(Polygon<Vector2> polygon : this)
            for(Vector2 vertex : polygon.getVertices())
                vertex.subtract(average).multiply(scalar);

    }

    @Override
    public void translate(Vector2 vector) {
        for(Polygon<Vector2> polygon : this)
            polygon.translate(vector);
    }

    @Override
    public Vector2 average() {
        List<Vector2> vertices = new ArrayList<>();

        for(Polygon<Vector2> polygon : this)
            vertices.addAll(List.of(polygon.getVertices()));

        return VectorUtils.average(vertices.toArray(new Vector2[0]));
    }
}
