package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

class Helipad extends Fixed{

    private Point location;
    public Helipad(){
        init();
    }

    private void init(){

        //set the location of the helipad equal
        //to middle of screen at the bottom (9/10 of the way down)
        location = new Point(   Game.DISP_W / 2,
                Game.DISP_H -
                        Game.DISP_H / 10);
    }
    public void draw(Graphics g) {

        g.setColor(ColorUtil.GRAY);

        int length = Game.DISP_W/20;
        int width = Game.DISP_W/20;

        g.drawRect(location.getX() ,location.getY(), width, length);
        g.drawArc(location.getX(),location.getY(),
                width, length, 0, 360);
    }

    //need this specific getter to make sure
    //the helicopter and helipad spawn with each other
    public Point getLocation(){
        return location;
    }
}

