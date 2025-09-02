package de.maplesoft.renderengine.swing;

import de.maplesoft.renderengine.annotation.CoreOperation;
import de.maplesoft.renderengine.object.gameobject.GameObject;
import de.maplesoft.renderengine.geo.shape.Shape;
import de.maplesoft.renderengine.geo.shape.impl.Triangle;
import de.maplesoft.renderengine.geo.shape.trigshape.Trigshape;
import de.maplesoft.renderengine.space.Scene;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class RenderFrame extends JFrame {
    private final List<Shape> renderList;

    private final Thread tickThread, frameThread;

    private final AtomicBoolean clearNextFrame = new AtomicBoolean();

    private Scene currentScene;

    @Setter
    private int framespeed = 50;

    @Setter
    private int tickspeed = 20;

    public RenderFrame(Scene scene){
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

    public void loadScene(Scene scene) {
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
    public void add(Shape shape) {
        this.renderList.add(shape);
    }

    @CoreOperation
    public void add(Trigshape shape) {
        for(Triangle triangle : shape.getTriangles())
            this.add(triangle);
    }

    @CoreOperation
    public void remove(Shape shape) {
        this.renderList.remove(shape);
    }

    public void tick() {
        while(this.isVisible() && this.currentScene != null) {
            for(GameObject gameObject : currentScene.getGameObjects())
                gameObject.tickComponents();

            try {
                Thread.sleep(tickspeed);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void frame() {
        while(this.isVisible() && this.currentScene != null) {
            this.clearNextFrame.set(!this.clearNextFrame.get());

            for(GameObject gameObject : currentScene.getGameObjects())
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


        for(Shape shape : renderList)
            g.drawPolygon(shape.toSwingPolygon());


//        g.drawOval(40, 40, 60, 60); //FOR CIRCLE
//        g.drawRect(80, 30, 200, 200); // FOR SQUARE
//        g.drawRect(200, 100, 100, 200); // FOR RECT
    }
}
