package de.maplesoft.renderengine.renderobject.gameobject.component.impl;

import de.maplesoft.renderengine.renderobject.gameobject.component.Component;
import de.maplesoft.renderengine.space.space3d.Polygon3;
import de.maplesoft.renderengine.space.space3d.Polygons3;
import de.maplesoft.renderengine.space.space3d.Vector3;
import de.maplesoft.renderengine.space.space3d.polygons.Point3D;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public final class Mesh3D implements Component {
    @Getter
    private final Polygons3 polygons;

    public Mesh3D(Polygons3 polygons) {
        this.polygons = polygons;
    }

    public Mesh3D() {
        this.polygons = new Polygons3();
    }

    public static Mesh3D singleton(Vector3 location) {
        return new Mesh3D(
                Polygons3.of(new Point3D(location))
        );
    }
}
