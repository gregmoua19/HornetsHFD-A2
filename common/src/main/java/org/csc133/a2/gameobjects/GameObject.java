package org.csc133.a2.gameobjects;

import org.csc133.a2.interfaces.Drawable;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Dimension;

public abstract class GameObject implements Drawable {

    //must be general that applies to all

     Point point;
     Dimension dim;
     int color;
     int budgetArea;
     int building;
     int value;
     int damage;

    //Init method
    public abstract void init();

    //Collision method
    public boolean collidesWith(GameObject other) {
        return (other.getPoint().getY() <= point.getY())
                && (other.getPoint().getY() + other.getDim().getHeight() >= point.getY())
                && (other.getPoint().getX() <= point.getX())
                && (other.getPoint().getX() + other.getDim().getWidth() >= point.getX());
    }

    public abstract int getSize();

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

    public void grow() {
    }

    public int getBudgetArea(){
        return budgetArea;
    }

    public int getBuilding(){
        return building;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public abstract String toString();

    protected void setSize(int size) {
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    protected void setState(Extinguished instance) {
    }

}
