package de.maplesoft.renderengine.space.polygon;

import de.maplesoft.renderengine.space.space2d.Polygon2;
import de.maplesoft.renderengine.space.space2d.Polygons2;
import de.maplesoft.renderengine.space.space2d.Vector2;
import de.maplesoft.renderengine.space.space3d.Polygon3;
import de.maplesoft.renderengine.space.space3d.Polygons3;
import de.maplesoft.renderengine.space.space3d.Vector3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Polygons<V> extends ArrayList<Polygon<V>> {
    public Polygons() {
        super();
    }

    public Polygons(Collection<? extends Polygon<V>> polygons) {
        super(polygons);
    }

    public abstract void scale(double scalar);

    public abstract void translate(V vector);

    public abstract V average();

    public static Polygons3 of(Polygon3... polygons) {
        return new Polygons3(List.of(polygons));
    }

    public static Polygons2 of(Polygon2... polygons) {
        return new Polygons2(List.of(polygons));
    }
}
