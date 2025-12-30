package de.maplesoft.renderengine.exception.scene;

public class NullSceneException extends SceneException {
    public NullSceneException() {
        super("Attempted to operate on a scene even though no scene is loaded");
    }
}
