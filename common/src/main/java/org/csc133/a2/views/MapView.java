package org.csc133.a2.views;

import com.codename1.ui.CN;
import org.csc133.a2.Game;
import org.csc133.a2.GameWorld;
import org.csc133.a2.gameobjects.GameObject;

import java.awt.*;

public class MapView extends Container {
    private GameWorld gw;
    public MapView(GameWorld gw) {
        this.gw = gw;
    }

    public void draw(Graphics g, Container c) {
        for(GameObject go : gw.getGameObjectCollection()) {
            go.draw();
        }
    }

    public void update() {
        repaint();
    }
}
