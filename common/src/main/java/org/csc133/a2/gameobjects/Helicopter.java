package org.csc133.a2.gameobjects;


import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.gameobjects.Fire;
import org.csc133.a2.Game;
import org.csc133.a2.gameobjects.Helipad;
import org.csc133.a2.gameobjects.River;

import java.awt.*;

class Helicopter extends Movable{
    private Point location;
    private int fuel;
    private int water;
    private int speed;
    private int heading;
    private org.csc133.a2.gameobjects.Helipad helipad;
    private Point lineLocation;
    private double radianHeading;
    public Helicopter(){
        init();
    }

    public void init(){
        int height = Game.DISP_H / 50;
        int width = Game.DISP_W / 30;
        radianHeading = 0;
        fuel = 25000;
        speed = 0;
        water = 0;
        helipad = new org.csc133.a2.gameobjects.Helipad();
        heading = 0;

        location = new Point(
                helipad.getLocation().getX() + width/2,
                helipad.getLocation().getY() + height);
        lineLocation = new Point(
                location.getX() + 25,
                location.getY() - 100
        );
    }




    public Point getLocation() {
        return location;
    }

    public int getFuel() { return fuel;}

    public int getSpeed() {return speed;}

    public void drinkWater(){
        if (speed <= 2 && water < 1000) {
            water += 100;
        }
    }

    //rather than making one method for speedup and
    //another for slowdown, I chose to make one that
    //use a boolean parameter to either increase or decrease
    public void changeSpeed(boolean speedUp) {

        //check speed first to make sure it's
        //between 0-10 between allowing it to be changed
        if(speedUp == false && speed > 0) {
            speed -= 1;
        } else if (speedUp == true && speed < 10) {
            speed += 1;
        }
    }

    public void fight(org.csc133.a2.gameobjects.Fire fire){
        if (collidesWithFire(fire)) {
            water -= fire.getSize();
            fire.setSize(-water);
            if (water < 0) {
                water = 0;
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(ColorUtil.YELLOW);

        //drawing a filled circle and line relative to its location
        g.fillArc(location.getX(),
                location.getY(),
                50,50,
                0,360);
        g.drawLine(location.getX() + 25,
                location.getY() + 25,

                //x1 y1 guarantees that the line starts
                //in the center of the circle but the
                //x2 y2 are dictated by the angle of the heading
                lineLocation.getX(),
                lineLocation.getY());
        g.drawString("Water: " + water,
                location.getX(),
                location.getY()  + 100);

        g.drawString("Fuel: " + fuel,
                location.getX(),
                location.getY() + 60);
    }

    public void walk(){

        //take angle
        //360/15 = 24
        //that means there's only 24 places you can draw the line
        fuel = fuel - ((speed * speed) + 5);

        //4 if statements based off quadrants
        //take into account that y is flipped
        //1 to 89
        //91 to 179
        //181 to 269
        //271 to 359 AKA 0-1
        //specific conditionals for 0,90,180,270 implemented
        int decX = (int)(location.getX() - speed*2*Math.cos(radianHeading));
        int decY = (int)(location.getY() - speed*2*Math.sin(radianHeading));
        if(heading > 0 && heading < 90) {
            location.setX(decX);
            location.setY(decY);
        } else if (heading > 90 && heading < 180) {
            location.setX(decX);
            location.setY(decY);
        } else if (heading > 180 && heading < 270) {
            location.setX(decX);
            location.setY(decY);
        } else if (heading > 270){
            location.setX(decX);
            location.setY(decY);
        } else if (heading == 0){
            location.setY(decY);
        } else if (heading == 90) {
            location.setX(decX);
        } else if (heading == 180) {
            location.setY(decY);
        } else if (heading == 270) {
            location.setX(decX);
        }

        lineLocation.setX((int)((location.getX() + 25)
                - 80 * Math.cos(radianHeading)));
        lineLocation.setY((int)((location.getY() + 25)
                - 80 * Math.sin(radianHeading)));

    }

    public void steer(boolean direction){
        //turn right so +15
        if(direction) {

            //conditionals to change heading by 15 degrees
            //once it hits 360 it will jump to 15
            if(heading == 360 || heading == 0) {
                heading = 15;
            } else {
                heading += 15;
            }
            //turn left so -15
        } else {

            //conditionals to change heading by 15 degrees
            //once it hits 0 it will jump to 345
            if (heading == 0 || heading == 360) {
                heading = 345;
            } else {
                heading -= 15;
            }
        }

        //just like in easy clock the 24 represents 360/15
        //meaning there are 24 possible places for the line to turn
        //and the 15 is representative of which area was selected
        radianHeading = Math.toRadians(360/24 * (heading /15) + 90);
    }

    public boolean collidesWithRiver(org.csc133.a2.River river) {
        int YRiver = river.getLocation().getY();
        int dispHeight = Game.DISP_H / 10;
        return (YRiver <= this.getLocation().getY()) &&
                YRiver + dispHeight >= this.getLocation().getY();
    }

    public boolean collidesWithFire(org.csc133.a2.Fire fire) {
        int fireXLoc = fire.getLocation().getX();
        int fireYLoc = fire.getLocation().getY();
        return (fireYLoc <= location.getY())
                && (fireYLoc + fire.getSize() >= location.getY())
                && (fireXLoc <= location.getX())
                && (fireXLoc + fire.getSize() >= location.getX());
    }

    @Override
    public boolean collidesWith(GameObject first, GameObject second) {
        return false;
    }

    @Override
    public int getSize(Dimension d) {
        return 0;
    }

    @Override
    public void draw(java.awt.Graphics g, java.awt.Point containerOrigin) {
        g.setColor(ColorUtil.YELLOW);

        //drawing a filled circle and line relative to its location
        g.fillArc(location.getX(),
                location.getY(),
                50,50,
                0,360);
        g.drawLine(location.getX() + 25,
                location.getY() + 25,

                //x1 y1 guarantees that the line starts
                //in the center of the circle but the
                //x2 y2 are dictated by the angle of the heading
                lineLocation.getX(),
                lineLocation.getY());
        g.drawString("Water: " + water,
                location.getX(),
                location.getY()  + 100);

        g.drawString("Fuel: " + fuel,
                location.getX(),
                location.getY() + 60);
    }

    @Override
    public void steerLeft() {

    }

    @Override
    public void steerRight() {

    }
}
