package de.maplesoft.renderengine.renderobject.gameobject;

import de.maplesoft.renderengine.exception.InvalidComponentException;
import de.maplesoft.renderengine.renderobject.gameobject.component.Component;
import de.maplesoft.renderengine.renderobject.gameobject.component.Components;
import de.maplesoft.renderengine.renderobject.gamescript.GameScript;
import de.maplesoft.renderengine.space.polygon.Polygons;
import lombok.Getter;
import lombok.Setter;

import java.util.TreeSet;

public abstract class GameObject<V> {
    @Getter @Setter
    protected String name;

    @Getter
    protected final Components components;
    protected GameObject(Components components, String name) {
        this.components = components;
        this.name = name;
    }

    @Override
    public abstract GameObject<V> clone();

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

    /**
     * Get a component (game object parameter) by type
     * @param type component class
     * @return found component
     * @param <T> return type (same as component class type)
     * @throws InvalidComponentException if component not found
     */
    public <T extends Component> T getComponent(Class<T> type) throws InvalidComponentException {
        T result = this.getComponent(type, null);

        if(result != null)
            return result;
        else
            throw new InvalidComponentException(type, this);
    }

    /**
     * Get a component (game object parameter) by type without throwing an exception
     * @param type component class
     * @param fallback value to return if component isn't contained
     * @return found component
     * @param <T> return type (same as component class type)
     */
    public <T extends Component> T getComponent(Class<T> type, T fallback) {
        for(Component component : components)
            if(type.isInstance(component))
                return type.cast(component);

        return fallback;
    }
}
