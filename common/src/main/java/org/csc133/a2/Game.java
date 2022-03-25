package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.UITimer;
import org.csc133.a2.commands.*;
import org.csc133.a2.gameobjects.GameObject;
import org.csc133.a2.views.GlassCockpit;
import org.csc133.a2.views.MapView;

import java.awt.*;

public class Game extends Form implements Runnable{
    private GameWorld gw;
    private GlassCockpit gcp;
    private MapView mv;

    public final static int DISP_W = Display.getInstance().getDisplayWidth();
    public final static int DISP_H = Display.getInstance().getDisplayHeight();

    public Game(){
        gw = new GameWorld();
        gcp = new GlassCockpit(gw);
        mv = new MapView(gw);
/*
        addKeyListener('Q', (evt) -> gw.quit());
        addKeyListener( -91, (ActionListener) new AccelerateCommand(gw));
        addKeyListener(-92, new BrakeCommand(gw));
        addKeyListener(-93, new TurnLeftCmmand(gw));
        addKeyListener(-94, new TurnRightCommand(gw));
        addKeyListener('f', new FightCommand(gw));
        addKeyListener('d', new DrinkCommand(gw));
*/
        UITimer timer = new UITimer(this);
        timer.schedule(200, true, this);

        this.getAllStyles().setBgColor(ColorUtil.BLACK);
        this.show();
    }

    public void paint(Graphics g) {
        //super.paint(g);

        //method where all objects drawn
        //mv.draw(g, Container c);
    }

    @Override
    public void run() {
        //gw.tick();
        repaint();
        //mv.update();
    }
}

