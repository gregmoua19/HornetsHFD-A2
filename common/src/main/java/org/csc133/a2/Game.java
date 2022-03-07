package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.util.UITimer;
import org.csc133.a2.commands.*;

public class Game extends Form implements Runnable{
    private GameWorld gw;

    public final static int DISP_W = Display.getInstance().getDisplayWidth();
    public final static int DISP_H = Display.getInstance().getDisplayHeight();

    public Game(){
        gw = new GameWorld();

        addKeyListener('Q', (evt) -> gw.quit());
        addKeyListener( -91, new AccelerateCommand(gw));
        addKeyListener(-92, new BrakeCommand(gw));
        addKeyListener(-93, new TurnLeftCmmand(gw));
        addKeyListener(-94, new TurnRightCommand(gw));
        addKeyListener('f', new FightCommand(gw));
        addKeyListener('d', new DrinkCommand(gw));

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

