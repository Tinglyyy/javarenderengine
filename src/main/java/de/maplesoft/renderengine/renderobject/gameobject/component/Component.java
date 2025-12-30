package de.maplesoft.renderengine.renderobject.gameobject.component;

public interface Component {
    default void reload() {}
    default void tick() {}
}
