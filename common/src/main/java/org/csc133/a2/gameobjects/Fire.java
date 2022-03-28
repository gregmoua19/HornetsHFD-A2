package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Dimension;
import org.csc133.a2.Game;

import java.util.Random;

public class Fire extends Fixed{
    private int size;

    public Fire(){
        init();
    }

    public void init(){
        this.color = ColorUtil.MAGENTA;
        size = new Random().nextInt(5)+15;
        dim = new Dimension(size,size);
        point = new Point(new Random().nextInt(Game.DISP_W),
                new Random().nextInt(Game.DISP_H));
    }

    public void grow(){
        size += new Random().nextInt(2);
    }

    public void setSize(int size) { this.size = size;}

    public void setLocation(Point point){
        dim.setWidth(point.getX());
        dim.setHeight(point.getY());
    }



    @Override
    public boolean collidesWith(GameObject other) {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String toString() {
        return "Fire";
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        int x = containerOrigin.getX() +
                point.getX();
        int y = containerOrigin.getY() +
                point.getY();
        g.setColor(color);
        if(size > 0) {
            g.fillArc(x,
                    y,
                    size, size,
                    0, 360);
            g.drawString ("" + size,
                    x + size,
                    y + size);
        }
    }

    public void start() {

    }


}

