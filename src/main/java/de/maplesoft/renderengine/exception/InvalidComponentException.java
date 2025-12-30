package de.maplesoft.renderengine.exception;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.component.Component;

public class InvalidComponentException extends RuntimeException {
    public <G extends GameObject> InvalidComponentException(Class<? extends Component> searched, G object) {
        super(STR."Couldn't find component(s) of type \{searched.getSimpleName()} in object instance\{object}");

    }
}
