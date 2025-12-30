package de.maplesoft.renderengine.space.space2d.polygons;

import de.maplesoft.renderengine.space.space2d.Polygon2;
import de.maplesoft.renderengine.space.space2d.Vector2;

public class Point2D extends Polygon2 {
    public Point2D(Vector2 location) {
        super(new Vector2[]{location});
    }
}
