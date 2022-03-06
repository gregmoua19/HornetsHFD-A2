package org.csc133.a2.views;

import com.codename1.ui.CN;
import org.csc133.a2.Game;
import org.csc133.a2.GameWorld;

import java.awt.*;

public class MapView extends Container {
    public MapView(GameWorld gw) {

    }

    public void draw(Graphics g, Container c) {
        g.clearRect(0,0, Game.DISP_W, Game.DISP_H);
        helicopter.draw(g);
        river.draw(g);
        helipad.draw(g);
        for (Fire fire : fires) {
            fire.draw(g);
        }
        tick();
        g.setFont(com.codename1.ui.Font.createSystemFont(CN.FACE_MONOSPACE,
                CN.STYLE_PLAIN,
                CN.SIZE_MEDIUM));
    }

    public void update() {
        repaint();
    }
}
