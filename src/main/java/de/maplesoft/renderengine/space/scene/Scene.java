package de.maplesoft.renderengine.space.scene;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.component.impl.IDComponent;
import de.maplesoft.renderengine.space.grid.Grid;
import lombok.Getter;

import java.util.Map;

public abstract class Scene<V> {
    @Getter
    protected final Map<String, GameObject<V>> gameObjects;
    @Getter
    protected final Grid<V> grid;

    @Getter
    private static Scene<?> currentScene = null;

    /**
     * Instanciates a new scene
     * ! Load the scene before performing scene operations, else you'll get <code>NullSceneException</code> !
     * @param grid dimensional grid to place game objects on
     * @param gameObjects game objects to place
     */
    protected Scene(Grid<V> grid, Map<String, GameObject<V>> gameObjects) {
        this.grid = grid;
        this.gameObjects = gameObjects;

        this.grid.placeObjects(gameObjects.values());
    }

    public void setId(String id, String previous) {
        GameObject<V> gameObject = this.gameObjects.get(previous);

        this.gameObjects.remove(previous);

        this.gameObjects.put(id, gameObject);
    }

    public void add(GameObject<V> gameObject) {
        this.add(gameObject.getComponent(IDComponent.class).getId(), gameObject);
    }

    public void add(String id, GameObject<V> gameObject) {
        this.gameObjects.put(id, gameObject);
    }

    public void remove(GameObject<V> gameObject) {
        this.gameObjects.forEach((id, object) -> {
            if(gameObject.equals(object))
                this.gameObjects.remove(id);
        });
    }

    public void remove(String id) {
        this.gameObjects.remove(id);
    }

    public void reloadScripts() {
        for(GameObject<V> gameObject : this.gameObjects.values())
            gameObject.reloadScripts();
    }

    public void reloadGameObjects() {
        for(GameObject<V> gameObject : this.gameObjects.values())
            gameObject.reload();
    }

    public void reload() {
        this.reloadScripts();
        this.reloadGameObjects();
    }

    public void unload() {
        currentScene = null;
    }

    public void load() {
        currentScene = this;
    }

}
