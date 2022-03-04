package org.csc133.a2.gameobjects;

import java.awt.*;

public class Building extends Fixed{
    @Override
    public void init() {

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
    public void draw(Graphics g, Point containerOrigin) {

    }
}
