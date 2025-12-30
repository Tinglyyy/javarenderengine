package de.maplesoft.renderengine.space.polygon;

import java.util.ArrayList;
import java.util.Collection;

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
}
