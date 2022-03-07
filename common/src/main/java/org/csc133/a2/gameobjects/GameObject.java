package org.csc133.a2.gameobjects;

import org.csc133.a2.interfaces.Drawable;

import java.awt.*;

public abstract class GameObject implements Drawable {

    //must be general that applies to all

    private Point point;
    private Dimension dim;
    private int color;

    //Init method
    public abstract void init();

    //Collision method
    public abstract boolean collidesWith(GameObject other);

    public Point getPoint(){
        return point;
    }

    public void setPoint(Point point){
        this.point = point;
    }

    public Dimension getDim(){
        return dim;
    }

    public void setDim(Dimension dim){
        this.dim = dim;
    }

    public int getColor() {
        return color;
    }

    public void changeColor(int color) {
        this.color = color;
    }
}
