package org.csc133.a2.gameobjects;

import org.csc133.a2.interfaces.Steerable;

import java.awt.*;

public abstract class Movable extends GameObject implements Steerable {
    @Override
    public abstract void init();

    @Override
    public abstract boolean collidesWith(GameObject first, GameObject second);

    @Override
    public abstract int getSize(Dimension d);

    @Override
    public abstract void draw(Graphics g, Point containerOrigin);

    @Override
    public abstract void steerLeft();

    @Override
    public abstract void steerRight();
}
