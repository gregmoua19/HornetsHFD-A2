package org.csc133.a2.gameobjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Dimension;

public class Building extends Fixed{
    int value;
    int damage;

    @Override
    public void init() {
        damage = 0;
        value = 10000;

    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public boolean collidesWith(GameObject other) {
        return false;
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {

    }

    @Override
    public Dimension getSize(Dimension d) {
        return d;
    }



    public void setFireinBuilding(Fire fire) {

    }
}
