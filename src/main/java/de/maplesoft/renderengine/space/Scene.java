package de.maplesoft.renderengine.space;

import de.maplesoft.renderengine.object.gameobject.GameObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    @Getter
    protected final List<GameObject> gameObjects;

    public Scene(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public Scene() {
        this(new ArrayList<>());
    }

    public void add(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
    }

    // TODO
    public void reloadScripts() {
        for(GameObject gameObject : gameObjects)
            gameObject.reloadScripts();
    }

    public void reloadGameObjects() {
        for(GameObject gameObject : gameObjects)
            gameObject.reload();
    }

    public void reload() {
        this.reloadScripts();
        this.reloadGameObjects();
    }


}
