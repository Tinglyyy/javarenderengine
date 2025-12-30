package de.maplesoft.renderengine.renderobject.gameobject.component;

import org.jetbrains.annotations.NotNull;

public interface Component extends Comparable<Component> {
    int getRanking();

    default void reload() {}
    default void tick() {}

    default @Override int compareTo(@NotNull Component o) {
        return o.getRanking() - this.getRanking();
    }
}
