package de.maplesoft.renderengine;


import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.renderobject.gameobject.defaults.FaceObject;
import de.maplesoft.renderengine.space.scene.Scene3D;
import de.maplesoft.renderengine.swing.RenderFrame;

public class Main {
    public static RenderFrame initFrame() {
        RenderFrame frame = new RenderFrame();

        frame.setVisible(true);

        Scene3D scene3D = new Scene3D();

        GameObject gameObject = new FaceObject();

        scene3D.add(gameObject);

        frame.loadScene(scene3D);

        return frame;
    }

    public static void main(String[] args) {
        initFrame();
    }
}
