package de.maplesoft.renderengine.renderobject.sceneobject.defaults;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.space.polygon.Polygon;
import de.maplesoft.renderengine.space.scene.Scene;

public interface Camera<V> {
    boolean isOnScreen(GameObject<V> gameObject);

    Polygon<V> getOnScreen(Polygon<V> polygon);

    void setFov(double fov);

    double getFov();

    void setRenderDistance(int renderDistance);

    int getRenderDistance();

    void render(Scene<V> scene);
}
