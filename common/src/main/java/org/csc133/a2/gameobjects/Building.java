package org.csc133.a2.gameobjects;

import java.awt.*;

public class Building extends Fixed{
    int value;
    int damage;

    @Override
    public void init() {
        damage = 0;
        value = 10000;

    }

    @Override
    public boolean collidesWith(GameObject other) {
        return false;
    }

    @Override
    public Dimension getSize(Dimension d) {
        return d;
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {

    }

    public void setFireinBuilding(Fire fire) {

    }
}
