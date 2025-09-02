package de.maplesoft.renderengine.object.gameobject.component.impl;

import de.maplesoft.renderengine.object.gameobject.component.Component;
import de.maplesoft.renderengine.space.space2d.Vector2;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public final class Transform2D implements Component {
    /**
     * Attributes of 2d Transform; _I- versions are initial fields for reloading
     */

    private Vector2 rotation, _IRotation;
    private Vector2 scale, _IScale;
    private Vector2 anchor, _IAnchor;
    private Vector2 position, _IPosition;

    public Transform2D(Vector2 rotation, Vector2 scale, Vector2 anchor, Vector2 position) {
        this.rotation = rotation;
        this._IRotation = rotation.clone();

        this.scale = scale;
        this._IScale = scale.clone();

        this.anchor = anchor;
        this._IAnchor = anchor.clone();

        this.position = position;
        this._IPosition = position.clone();
    }

    public static Transform2D origin() {
        return new Transform2D(Vector2.zero(), new Vector2(1, 1), Vector2.zero(), Vector2.zero());
    }

    public void moveX(double x) {
        this.position.addX(x);
    }

    public void moveY(double y) {
        this.position.addY(y);
    }

    public void move(Vector2 vector) {
        this.position.add(vector);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Transform2D) obj;
        return Objects.equals(this.rotation, that.rotation) &&
                Objects.equals(this.scale, that.scale) &&
                Objects.equals(this.anchor, that.anchor) &&
                Objects.equals(this.position, that.position);
    }

    @Override
    public String toString() {
        return "Transform2D[" +
                "rotation=" + rotation + ", " +
                "scale=" + scale + ", " +
                "anchor=" + anchor + ", " +
                "position=" + position + ']';
    }

    @Override
    public Transform2D clone() {
        return new Transform2D(
                this.rotation.clone(),
                this.scale.clone(),
                this.anchor.clone(),
                this.position.clone());
    }

    @Override
    public void reload() {
        this.position = _IPosition.clone();
        this.rotation = _IRotation.clone();
        this.scale = _IScale.clone();
        this.anchor = _IAnchor.clone();

    }

    // Nothing happens on transform tick
    @Override
    public void tick() {

    }

}
