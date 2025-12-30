package de.maplesoft.renderengine;


import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.defaults.EmptyGameObject3D;
import de.maplesoft.renderengine.space.scene.Scene3D;
import de.maplesoft.renderengine.space.space3d.Vector3;
import de.maplesoft.renderengine.swing.RenderFrame;

public class Main {
    public static RenderFrame<Vector3> initFrame() {
        RenderFrame<Vector3> frame = new RenderFrame<>();

        frame.setVisible(true);

        Scene3D scene3D = new Scene3D();

        scene3D.load();

        EmptyGameObject3D gameObject = new EmptyGameObject3D("Object1");

        scene3D.add(gameObject);

        frame.loadScene(scene3D);

        return frame;
    }

    public static void main(String[] args) {
        initFrame();
    }
}
