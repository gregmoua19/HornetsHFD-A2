package org.csc133.a2.gameobjects;

import org.csc133.a2.interfaces.Drawable;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Dimension;


public abstract class Fixed extends GameObject{

    @Override
    public abstract void init();

    public abstract Dimension getSize();

    @Override
    public abstract boolean collidesWith(GameObject other);

    @Override
    public abstract void draw(Graphics g, Point containerOrigin);

    public abstract Dimension getSize(Dimension d);
}
