package org.csc133.a2.gameobjects;

import org.csc133.a2.interfaces.Drawable;

import java.awt.*;

public abstract class Fixed extends GameObject{

    @Override
    public abstract void init();

    @Override
    public abstract boolean collidesWith(GameObject other);

    @Override
    public abstract int getSize(Dimension d);

    @Override
    public abstract void draw(Graphics g, Point containerOrigin);
}
