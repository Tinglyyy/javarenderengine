package de.maplesoft.renderengine.swing;

import de.maplesoft.renderengine.annotation.CoreOperation;
import de.maplesoft.renderengine.rendergeo.shape.RenderShape;
import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.rendergeo.shape.impl.RTrig;
import de.maplesoft.renderengine.rendergeo.shape.trigshape.Trigshape;
import de.maplesoft.renderengine.space.scene.Scene3D;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class RenderFrame extends JFrame {
    private final List<RenderShape> renderList;

    private final Thread tickThread, frameThread;

    private final AtomicBoolean clearNextFrame = new AtomicBoolean();

    private Scene3D currentScene3D;

    @Setter
    private int framespeed = 50;

    @Setter
    private int tickspeed = 20;

    public RenderFrame(Scene3D scene3D){
        setSize(1020,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.renderList = new ArrayList<>();

        this.tickThread = new Thread(this::tick);
        this.frameThread = new Thread(this::frame);

        this.currentScene3D = scene3D;
    }

    public RenderFrame() {
        this(null);
    }

    public void loadScene(Scene3D scene3D) {
        this.currentScene3D = scene3D;
        this.setVisible(true);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);

        if(visible && this.currentScene3D != null) {
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
        while(this.isVisible() && this.currentScene3D != null) {
            for(GameObject gameObject : currentScene3D.getGameObjects())
                gameObject.tickComponents();

            try {
                Thread.sleep(tickspeed);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void frame() {
        while(this.isVisible() && this.currentScene3D != null) {
            this.clearNextFrame.set(!this.clearNextFrame.get());

            for(GameObject gameObject : currentScene3D.getGameObjects())
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


//        g.drawOval(40, 40, 60, 60); //FOR CIRCLE
//        g.drawRect(80, 30, 200, 200); // FOR SQUARE
//        g.drawRect(200, 100, 100, 200); // FOR RECT
    }
}
