package de.maplesoft.renderengine.renderobject.gameobject.defaults;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.component.Component;
import de.maplesoft.renderengine.renderobject.gameobject.component.Components;
import de.maplesoft.renderengine.renderobject.gameobject.component.impl.Mesh3D;
import de.maplesoft.renderengine.renderobject.gameobject.component.impl.Transform3D;
import de.maplesoft.renderengine.space.polygon.Polygons;
import de.maplesoft.renderengine.space.space3d.Polygon3;
import de.maplesoft.renderengine.space.space3d.Vector3;

import java.util.Set;
import java.util.TreeSet;

@Deprecated(forRemoval = true)
public class TriangleObject3D extends GameObject<Vector3> {
    /**
     * Instantiate a 3D triangle with only the transform attribute (automatically set to center of triangle)
     * @param a points to first point
     * @param b points to second point
     * @param c points to third point
     * @param name name of instance
     */
    public TriangleObject3D(Vector3 a, Vector3 b, Vector3 c, String name) {
        Components components = Components.of(Transform3D.ofVectors(a, b, c));

        this(a, b, c, components, name);
    }

    /**
     * Instantiate a 3D triangle
     * @param a points to first point
     * @param b points to second point
     * @param c points to third point
     * @param components component set of instance
     * @param name name of instance
     */
    public TriangleObject3D(Vector3 a, Vector3 b, Vector3 c, Components components, String name) {
        components.add(new Mesh3D(Polygons.of(
                new Polygon3(a, b, c)
        )));
        super(components, name);
    }


    public TriangleObject3D(String name) {
        Vector3 a = new Vector3(-0.5, -0.5, 0),
                b = new Vector3(0.5, -0.5, 0),
                c = new Vector3(0, 0.5, 0);

        Components components = Components.of(Transform3D.ofVectors(a, b, c));

        this(a, b, c, components, name);
    }

//    public Triangle3D(Polygons<Vector3> polygons, TreeSet<Component> components, String name) {
//        super(polygons);
//    }

    @Override
    public GameObject<Vector3> clone() {
        return null;
    }
}
