package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

import java.awt.*;
import java.util.Random;

public class Fire extends Fixed{
    private Point location;
    private int size;

    public Fire(){
        init();
    }

    public void init(){
        size = new Random().nextInt(500)+50;
        location = new Point(new Random().nextInt(Game.DISP_W),
                new Random().nextInt(Game.DISP_H));
    }

    public Point getLocation() {
        return location;
    }
    public void grow(){
        size += new Random().nextInt(3);
    }

    public void setSize(int size) { this.size = size;}

    public void setLocation(Point point){

    }

    @Override
    public boolean collidesWith(GameObject other) {
        return false;
    }

    @Override
    public int getSize(Dimension d) {
        return size;
    }

    @Override
    public void draw(java.awt.Graphics g, java.awt.Point containerOrigin) {
        g.setColor(ColorUtil.MAGENTA);
        if(size > 0) {
            g.fillArc(location.getX(),
                    location.getY(),
                    size, size,
                    0, 360);
            g.drawString ("" + size,
                    location.getX() + size,
                    location.getY() + size);
        }
    }


}

