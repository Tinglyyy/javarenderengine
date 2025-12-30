package de.maplesoft.renderengine.renderobject.gamescript;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.component.Component;

public abstract class GameScript implements Component {

    /**
     * Set by scene when registering
     */
    public GameObject gameObject;

    /**
     * Set by scene when registering - When is the script called (lower callOrder ~ called earlier)
     */
    public int callOrder;

    @Override
    public void reload() {
        this.start();
    }

    // TODO
    protected void raiseCallOrder(int x) {

    }

    protected void lowerCallOrder(int x) {

    }

    public abstract void start();

    @Override
    public abstract void tick();

    public abstract void frame();
}
