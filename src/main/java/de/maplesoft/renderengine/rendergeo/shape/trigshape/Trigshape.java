package de.maplesoft.renderengine.rendergeo.shape.trigshape;

import de.maplesoft.renderengine.rendergeo.shape.impl.RTrig;
import de.maplesoft.renderengine.renderobject.gameobject.component.impl.Transform2D;
import lombok.Getter;

@Getter
public abstract class Trigshape {
    protected RTrig[] rTrigs;

    protected Transform2D transform;

    protected Trigshape(RTrig[] rTrigs, Transform2D transform) {
        this.rTrigs = rTrigs;

        this.transform = transform;
    }
}
