package de.maplesoft.renderengine.space.grid;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.space.space3d.Vector3;

import java.util.Collection;
import java.util.Set;

public interface Grid<V> {
    /**
     * Place all given GameObjects onto the grid at the given position
     * @param objects objects to place
     */
    void placeObjects(V location, GameObject<V>... objects);

    /**
     * Place all given GameObjects onto the grid
     * Looks for an RVector3 in the GameObjects' components
     * @param objects objects to place
     */
    void placeObjects(GameObject<V>... objects);

    void placeObjects(Collection<GameObject<V>> objects);

    void placeObjects(V location, Set<GameObject<V>> objects);

    void placeObject(GameObject<V> gameObject);

    public Set<GameObject<V>> getObjects(V location);
}
