package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Dimension;

public class Building extends Fixed{
    int value;
    int damage;

    @Override
    public void init() {
        this.color = ColorUtil.rgb(255,0,0);
        damage = 0;
        value = 10000;
        point = new Point(1,1);
        dim = new Dimension(1,1);

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
        return "Building";
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        g.drawRect(point.getX(),point.getY(),dim.getWidth(),dim.getHeight());
    }

    public void setFireinBuilding(Fire fire) {
        //fire.setLocation();
        fire.start();
    }
}
