package de.maplesoft.renderengine.renderobject.gameobject.component.impl;

import de.maplesoft.renderengine.renderobject.gameobject.component.Component;
import de.maplesoft.renderengine.space.space3d.Vector3;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public final class Transform3D implements Component {
    /**
     * Attributes of 2d Transform; _I- versions are initial fields for reloading
     */

    @Getter @Setter
    private Vector3 rotation, scale, anchor, position;


    private Vector3 _IRotation, _IScale, _IAnchor, _IPosition;

    public Transform3D(Vector3 rotation, Vector3 scale, Vector3 anchor, Vector3 position) {
        this.rotation = rotation;
        this._IRotation = rotation.clone();

        this.scale = scale;
        this._IScale = scale.clone();

        this.anchor = anchor;
        this._IAnchor = anchor.clone();

        this.position = position;
        this._IPosition = position.clone();
    }

    public static Transform3D origin() {
        return new Transform3D(Vector3.zero(), new Vector3(1, 1, 1), Vector3.zero(), Vector3.zero());
    }

    public void translateX(double x) {
        this.position.addX(x);
    }

    public void translateY(double y) {
        this.position.addY(y);
    }

    public void translateZ(double z) {
        this.position.addZ(z);
    }

    public void translate(Vector3 vector) {
        this.position.add(vector);
    }


    public void rotateX(double x) {
        this.rotation.addX(x);
    }

    public void rotateY(double y) {
        this.rotation.addY(y);
    }

    public void rotateZ(double z) {
        this.rotation.addZ(z);
    }

    public void rotate(Vector3 vector) {
        this.rotation.add(vector);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Transform3D) obj;
        return Objects.equals(this.rotation, that.rotation) &&
                Objects.equals(this.scale, that.scale) &&
                Objects.equals(this.anchor, that.anchor) &&
                Objects.equals(this.position, that.position);
    }

    @Override
    public String toString() {
        return STR."Transform3D[rotation=\{rotation}, scale=\{scale}, anchor=\{anchor}, position=\{position}]";
    }

    @Override
    public Transform3D clone() {
        return new Transform3D(
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
}
