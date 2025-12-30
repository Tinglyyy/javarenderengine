package de.maplesoft.renderengine.space.scene;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.space.grid.Grid;
import lombok.Getter;

import java.util.Set;

public abstract class Scene<V> {
    @Getter
    protected final Set<GameObject<V>> gameObjects;
    @Getter
    protected final Grid<V> grid;

    protected Scene(Grid<V> grid, Set<GameObject<V>> gameObjects) {
        this.grid = grid;
        this.gameObjects = gameObjects;

        this.grid.placeObjects(gameObjects);
    }

    public void add(GameObject<V> gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void remove(GameObject<V> gameObject) {
        this.gameObjects.remove(gameObject);
    }

    public void reloadScripts() {
        for(GameObject<V> gameObject : gameObjects)
            gameObject.reloadScripts();
    }

    public void reloadGameObjects() {
        for(GameObject<V> gameObject : gameObjects)
            gameObject.reload();
    }

    public void reload() {
        this.reloadScripts();
        this.reloadGameObjects();
    }
}
