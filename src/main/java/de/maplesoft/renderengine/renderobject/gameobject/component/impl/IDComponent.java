package de.maplesoft.renderengine.renderobject.gameobject.component.impl;

import de.maplesoft.renderengine.exception.InvalidIdentifierException;
import de.maplesoft.renderengine.exception.scene.NullSceneException;
import de.maplesoft.renderengine.renderobject.gameobject.component.Component;
import de.maplesoft.renderengine.space.scene.Scene;
import lombok.Getter;

public class IDComponent implements Component {
    @Getter
    private String id;

    public IDComponent(String id) {
        this.id = id;
    }

    public void setId(String id) {
        Scene<?> scene = Scene.getCurrentScene();

        if(scene == null)
            throw new NullSceneException();

        else if(scene.getGameObjects().containsKey(id))
            throw new InvalidIdentifierException(id);

        else {
            scene.setId(id, this.id);

            this.id = id;
        }
    }

    public static IDComponent ofName(String name) {
        Scene<?> scene = Scene.getCurrentScene();

        if(scene == null)
            throw new NullSceneException();

        int i = 0;

        while (scene.getGameObjects().containsKey(STR."\{name}_\{i}"))
            i++;

        if(i != 0)
            return new IDComponent(STR."\{name}_\{i}");
        else
            return new IDComponent(name);
    }

    @Override
    public int getRanking() {
        return -1;
    }
}
