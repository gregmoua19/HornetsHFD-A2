package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

import java.awt.*;

public class River extends Fixed{

    private Point location;
    public River(){
        init();
    }

    public void init() {
        location = new Point(0,
                Game.DISP_H / 3);
    }



    public void draw(Graphics g) {

        g.setColor(ColorUtil.BLUE);
        g.drawRect(location.getX(), location.getY(),
                Game.DISP_W,
                Game.DISP_H / 10);
    }

    public Point getLocation(){
        return location;
    }

    @Override
    public boolean collidesWith(GameObject other) {
        return false;
    }

    @Override
    public void draw(java.awt.Graphics g, java.awt.Point containerOrigin) {

    }
}
