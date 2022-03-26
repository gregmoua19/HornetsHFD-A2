package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;


public class River extends Fixed{

    private Point location;
    public River(){
        init();
    }

    public void init() {
        this.color = ColorUtil.BLUE;
        location = new Point(0,
                Game.DISP_H / 3);

    }

    public Point getLocation(){
        return location;
    }

    @Override
    public boolean collidesWith(GameObject other) {
        return false;
    }

    @Override
    public int getSize() {
        return this.getDim().getHeight();
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        g.drawRect(location.getX(), location.getY(),
                Game.DISP_W,
                Game.DISP_H / 10);
    }
}
