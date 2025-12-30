package de.maplesoft.renderengine.renderobject.gameobject.component.impl;

import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.component.Component;
import de.maplesoft.renderengine.space.space2d.Vector2;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Getter
@Setter
public final class Transform2D implements Component {
    /**
     * Attributes of 2d Transform; _I- versions are initial fields for reloading
     */
    private GameObject<Vector2> parent;

    private Vector2 rotation, _IRotation;
    private Vector2 scale, _IScale;
    private Vector2 anchor, _IAnchor;
    private Vector2 position, _IPosition;

    public Transform2D(GameObject<Vector2> parent, Vector2 rotation, Vector2 scale, Vector2 anchor, Vector2 position) {
        this.rotation = rotation;
        this._IRotation = rotation.clone();

        this.scale = scale;
        this._IScale = scale.clone();

        this.anchor = anchor;
        this._IAnchor = anchor.clone();

        this.position = position;
        this._IPosition = position.clone();
    }

    public static Transform2D origin(GameObject<Vector2> parent) {
        return new Transform2D(parent, Vector2.zero(), new Vector2(1, 1), Vector2.zero(), Vector2.zero());
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
        return STR."Transform2D[rotation=\{rotation}, scale=\{scale}, anchor=\{anchor}, position=\{position}]";
    }

    @Override
    public Transform2D clone() {
        return new Transform2D(
                this.parent,
                this.rotation.clone(),
                this.scale.clone(),
                this.anchor.clone(),
                this.position.clone());
    }


    @Override
    public int getRanking() {
        return 0;
    }

    @Override
    public void reload() {
        this.position = _IPosition.clone();
        this.rotation = _IRotation.clone();
        this.scale = _IScale.clone();
        this.anchor = _IAnchor.clone();

    }

    @Override
    public void tick() {
        Component.super.tick();
    }
}
