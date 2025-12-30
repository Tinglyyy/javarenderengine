package de.maplesoft.renderengine.space.space3d;

import de.maplesoft.renderengine.space.polygon.Polygon;
import de.maplesoft.renderengine.space.polygon.Polygons;
import de.maplesoft.renderengine.space.util.VectorUtils;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Polygons3 extends Polygons<Vector3> {
    public Polygons3(Collection<Polygon3> polygons) {
        super(polygons);
    }

    public Polygons3() {
        super();
    }

    @Override
    public void scale(double scalar) {
        Vector3 average = this.average();

        for(Polygon<Vector3> polygon : this)
            for(Vector3 vertex : polygon.getVertices())
                vertex.subtract(average).multiply(scalar);

    }

    @Override
    public void translate(Vector3 vector) {
        for(Polygon<Vector3> polygon : this)
            polygon.translate(vector);
    }

    @Override
    public Vector3 average() {

        List<Vector3> vertices = new ArrayList<>();

        for(Polygon<Vector3> polygon : this)
            vertices.addAll(List.of(polygon.getVertices()));

        return VectorUtils.average(vertices.toArray(new Vector3[0]));
    }

//    @org.jetbrains.annotations.Contract("_ -> new")
//    public static @NonNull Polygons3 of(Polygon3... polygons) {
//        return new Polygons3(List.of(polygons));
//    }
}
