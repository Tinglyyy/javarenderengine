package de.maplesoft.renderengine;


import de.maplesoft.renderengine.object.gameobject.GameObject;
import de.maplesoft.renderengine.object.gameobject.defaults.FaceObject;
import de.maplesoft.renderengine.space.Scene;
import de.maplesoft.renderengine.swing.RenderFrame;

public class Main {
    public static RenderFrame initFrame() {
        RenderFrame frame = new RenderFrame();

        frame.setVisible(true);

        Scene scene = new Scene();

        GameObject gameObject = new FaceObject();

        scene.add(gameObject);

        frame.loadScene(scene);

        return frame;
    }

    public static void main(String[] args) {
        initFrame();
    }
}
