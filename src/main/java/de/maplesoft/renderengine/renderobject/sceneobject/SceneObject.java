package de.maplesoft.renderengine.renderobject.sceneobject;

import de.maplesoft.renderengine.renderobject.RenderObject;
import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.space.space3d.Rot3;
import de.maplesoft.renderengine.space.space3d.Vector3;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * SceneObjects are fully separated from GameObjects, since they shouldn't be rendered in product render
 * This also means that SceneObjects cannot have Components
 */

public abstract class SceneObject implements RenderObject {
    @Getter @Setter
    protected Vector3 location;

    @Getter @Setter
    protected Rot3 rotation;

    @Override
    public abstract SceneObject clone();
}
