package de.maplesoft.renderengine.space.space3d.polygons;

import de.maplesoft.renderengine.space.space3d.Polygon3;
import de.maplesoft.renderengine.space.space3d.Vector3;

public class Triangle3D extends Polygon3 {
    public Triangle3D(Vector3 a, Vector3 b, Vector3 c) {
        super(a, b, c);
    }

    /**
     * Instantiate an equilateral 3D triangle at origin
     */
    public static Triangle3D origin() {
        return new Triangle3D(
                new Vector3(-0.5, -0.5, 0),
                new Vector3(0.5, -0.5, 0),
                new Vector3(0, 0.5, 0)
        );
    }
}
