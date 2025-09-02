package de.maplesoft.renderengine.object.gameobject;

import de.maplesoft.renderengine.object.gameobject.component.Component;
import de.maplesoft.renderengine.object.gamescript.GameScript;
import de.maplesoft.renderengine.geo.shape.trigshape.Trigshape;
import lombok.Getter;

import java.util.List;
import java.util.TreeSet;

public abstract class GameObject {
    @Getter
    protected final List<Trigshape> trigshapes;

    @Getter
    protected final TreeSet<Component> components;
    protected GameObject(List<Trigshape> trigshapes, TreeSet<Component> components) {
        this.trigshapes = trigshapes;
        this.components = components;
    }

    @Override
    public abstract GameObject clone();

    public void reload() {
        for(Component component : components)
            component.reload();
    }

    public void reloadScripts() {
        for(Component component : components)
            if(component instanceof GameScript script)
                script.reload();
    }

    public void tickComponents() {
        for(Component component : components)
            component.tick();
    }

    public void frameUpdateScripts() {
        for(Component component : components)
            if(component instanceof GameScript script)
                script.frame();
    }
}
