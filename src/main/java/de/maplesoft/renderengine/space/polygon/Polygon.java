package de.maplesoft.renderengine.space.polygon;

public interface Polygon <V> {
    void scale(double scalar);

    V getAnchor();

    V[] getVertices();

    void setVertices(V[] vertices);

    void translate(V vector);
}
