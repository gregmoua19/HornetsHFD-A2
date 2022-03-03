package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.util.UITimer;

class Game extends Form implements Runnable{
    private GameWorld gw;

    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    public static int getSmallDim() {
        return Math.min(DISP_W, DISP_H);
    }
    public static int getLargeDim(){
        return Math.max(DISP_W, DISP_H);
    }

    public Game(){
        gw = new GameWorld();

        addKeyListener('Q', (evt) -> gw.quit());
        addKeyListener( -91, (evt) -> gw.upArrowPressed());
        addKeyListener(-92, (evt) -> gw.downArrowPressed());
        addKeyListener(-93, (evt) -> gw.leftArrowPressed());
        addKeyListener(-94, (evt) -> gw.rightArrowPressed());
        addKeyListener('f', (evt) -> gw.fightFire());
        addKeyListener('d', (evt) -> gw.drinkWater());

        UITimer timer = new UITimer(this);
        timer.schedule(200, true, this);

        this.getAllStyles().setBgColor(ColorUtil.BLACK);
        this.show();
    }

    public void paint(Graphics g) {
        super.paint(g);
        gw.draw(g);
    }

    @Override
    public void run() {
        gw.tick();
        repaint();
    }
}

