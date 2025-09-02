package de.maplesoft.renderengine.object.sceneobject;

import de.maplesoft.renderengine.space.space3d.Vector3;
import lombok.Getter;
import lombok.Setter;

/**
 * SceneObjects are fully separated from GameObjects, since they shouldn't be rendered in product render
 * This also means that SceneObjects cannot have Components
 */

public abstract class SceneObject {
    @Getter @Setter
    protected Vector3 location;

    @Override
    public abstract SceneObject clone();
}
