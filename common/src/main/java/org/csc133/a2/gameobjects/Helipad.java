package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

public class Helipad extends Fixed{

    public Helipad(){
        init();
    }

    public void init(){

        this.color = ColorUtil.GRAY;
        //set the location of the helipad equal
        //to middle of screen at the bottom (9/10 of the way down)
        point = new Point(   Game.DISP_W / 2,
                Game.DISP_H -
                        Game.DISP_H / 10);
    }

    public void draw(Graphics g) {

        g.setColor(color);

        int length = Game.DISP_W/20;
        int width = Game.DISP_W/20;

        g.drawRect(point.getX() ,point.getY(), width, length);
        g.drawArc(point.getX(),point.getY(),
                width, length, 0, 360);
    }

    //need this specific getter to make sure
    //the helicopter and helipad spawn with each other

    @Override
    public boolean collidesWith(GameObject other) {

        return (other.getPoint().getY() <= point.getY())
                && (other.getPoint().getY() + other.getDim().getHeight() >= point.getY())
                && (other.getPoint().getX() <= point.getX())
                && (other.getPoint().getX() + other.getDim().getWidth() >= point.getX());
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String toString() {
        return "Helipad";
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        draw(g);
    }
}

