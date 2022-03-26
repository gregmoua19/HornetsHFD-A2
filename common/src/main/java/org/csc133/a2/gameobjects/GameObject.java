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

    //Init method
    public abstract void init();

    //Collision method
    public abstract boolean collidesWith(GameObject other);

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

    public int getColor() {
        return color;
    }

    public void changeColor(int color) {
        this.color = color;
    }
}
