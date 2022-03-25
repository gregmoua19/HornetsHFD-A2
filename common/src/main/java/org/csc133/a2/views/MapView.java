package org.csc133.a2.views;

import org.csc133.a2.GameWorld;
import org.csc133.a2.gameobjects.GameObject;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import java.awt.*;

public class MapView extends Container {
    private GameWorld gw;
    public MapView(GameWorld gw) {
        this.gw = gw;
    }

    public void paint(Graphics g) {
        super.paint(g);

        for(GameObject go : gw.getGameObjectCollection()) {
           go.draw(g, new Point(this.getX(), this.getY()));
        }
    }

    public void update() {
        repaint();
    }
}
