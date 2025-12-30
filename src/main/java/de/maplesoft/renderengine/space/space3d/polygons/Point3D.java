package de.maplesoft.renderengine.space.space3d.polygons;

import de.maplesoft.renderengine.space.space3d.Polygon3;
import de.maplesoft.renderengine.space.space3d.Vector3;

public class Point3D extends Polygon3 {
    public Point3D(Vector3 location) {
        super(new Vector3[]{location});
    }
}
