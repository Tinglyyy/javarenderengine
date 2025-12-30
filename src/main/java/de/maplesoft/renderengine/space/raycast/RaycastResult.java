package de.maplesoft.renderengine.space.raycast;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
public class RaycastResult <V> {
    private final Set<GameObject<V>> gameObjects;

    @Setter
    private double distance;

    public RaycastResult(Set<GameObject<V>> gameObjects, double distance) {
        this.gameObjects = gameObjects;
        this.distance = distance;
    }
    public static <V> RaycastResult<V> emptyResult() {
        return new RaycastResult<V>(Set.of(), -1);
    }
}
