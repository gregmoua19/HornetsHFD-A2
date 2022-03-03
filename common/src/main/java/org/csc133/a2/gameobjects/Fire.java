package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

import java.util.Random;

class Fire extends Fixed{
    private Point location;
    private int size;

    public Fire(){
        init();
    }

    private void init(){
        size = new Random().nextInt(500)+50;
        location = new Point(new Random().nextInt(Game.DISP_W),
                new Random().nextInt(Game.DISP_H));
    }
    public void draw(Graphics g) {
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

    public Point getLocation() {
        return location;
    }
    public void grow(){
        size += new Random().nextInt(3);
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size) { this.size = size;}

    public void setLocation(Point point){

    }

}

