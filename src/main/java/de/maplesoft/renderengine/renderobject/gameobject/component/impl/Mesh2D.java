package de.maplesoft.renderengine.renderobject.gameobject.component.impl;

import de.maplesoft.renderengine.renderobject.gameobject.component.Component;
import de.maplesoft.renderengine.space.space2d.Polygon2;
import lombok.Getter;

import java.util.List;

public final class Mesh2D implements Component {
    @Getter
    private final List<Polygon2> polygons;

    public Mesh2D(List<Polygon2> polygons) {
        this.polygons = polygons;
    }

    public void scale(double scalar) {

    }

    @Override
    public int getRanking() {
        return 1;
    }
}
