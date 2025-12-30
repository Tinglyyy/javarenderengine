package de.maplesoft.renderengine.renderobject.gamescript;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.component.Component;

public abstract class GameScript implements Component {

    private static final int HIGHEST_CALLORDER = 5000;

    /**
     * Set by scene when registering
     */
    public GameObject<?> gameObject;

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
        if(x < HIGHEST_CALLORDER && x >= 0 &&
                this.callOrder + x < HIGHEST_CALLORDER)
            this.callOrder += x;

    }

    protected void lowerCallOrder(int x) {
        if(this.callOrder - x > 0)
            this.callOrder -= x;
    }

    public void start() {
    }

    public void frame() {
    }

    @Override
    public int getRanking() {
        return 10 + this.callOrder;
    }
}
