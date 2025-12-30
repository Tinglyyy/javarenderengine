package de.maplesoft.renderengine.swing;

import de.maplesoft.renderengine.annotation.CoreOperation;
import de.maplesoft.renderengine.rendergeo.shape.RenderShape;
import de.maplesoft.renderengine.rendergeo.shape.impl.RTrig;
import de.maplesoft.renderengine.rendergeo.shape.trigshape.Trigshape;
import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.space.scene.Scene;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class RenderFrame<V> extends JFrame {
    private final List<RenderShape> renderList;

    private final Thread tickThread, frameThread;

    private final AtomicBoolean clearNextFrame = new AtomicBoolean();

    private Scene<V> currentScene;

    @Setter
    private int framespeed = 50;

    @Setter
    private int tickspeed = 20;

    public RenderFrame(Scene<V> scene){
        setSize(1020,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.renderList = new ArrayList<>();

        this.tickThread = new Thread(this::tick);
        this.frameThread = new Thread(this::frame);

        this.currentScene = scene;
    }

    public RenderFrame() {
        this(null);
    }

    public void loadScene(Scene<V> scene) {
        this.currentScene = scene;
        this.setVisible(true);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);

        if(visible && this.currentScene != null) {
            this.tickThread.start();
            this.frameThread.start();
        }
    }

    @CoreOperation
    public void add(RenderShape renderShape) {
        this.renderList.add(renderShape);
    }

    @CoreOperation
    public void add(Trigshape shape) {
        for(RTrig RTrig : shape.getRTrigs())
            this.add(RTrig);
    }

    @CoreOperation
    public void remove(RenderShape renderShape) {
        this.renderList.remove(renderShape);
    }

    public void tick() {
        while(this.isVisible() && this.currentScene != null) {
            for(GameObject<V> gameObject : this.currentScene.getGameObjects().values())
                gameObject.tickComponents();

            try {
                Thread.sleep(this.tickspeed);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void frame() {
        while(this.isVisible() && this.currentScene != null) {
            this.clearNextFrame.set(!this.clearNextFrame.get());

            for(GameObject<V> gameObject : currentScene.getGameObjects().values())
                gameObject.frameUpdateScripts();

            try {
                Thread.sleep(framespeed);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        if(this.renderList == null)
            return;

        if(this.clearNextFrame.get())
            g.clearRect(0, 0, getSize().width, getSize().height);


        for(RenderShape renderShape : renderList)
            g.drawPolygon(renderShape.toSwingPolygon());
    }
}
