package de.maplesoft.renderengine.space.raycast;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
public class RaycastResult {
    private final Set<GameObject> gameObjects;

    @Setter
    private double distance;

    public RaycastResult(Set<GameObject> gameObjects, double distance) {
        this.gameObjects = gameObjects;
        this.distance = distance;
    }
    public static RaycastResult emptyResult() {
        return new RaycastResult(Set.of(), -1);
    }
}
