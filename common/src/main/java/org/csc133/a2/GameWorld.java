package org.csc133.a2;

import com.codename1.ui.*;
import com.codename1.ui.geom.Point;

import java.util.ArrayList;
import java.util.Random;

public class GameWorld {
    private final int NUMBER_OF_FIRES = 3;
    private Helicopter helicopter;
    private ArrayList<Fire> fires;
    private Helipad helipad;
    private River river;
    private int increment;

    public GameWorld(){
        helicopter = new Helicopter();
        helipad = new Helipad();
        river = new River();
        fires = new ArrayList<>();

        for(int i = 0; i < NUMBER_OF_FIRES;i++) {
            fires.add(new Fire());

            if(i == 0) {
                fires.get(i).setLocation(
                        new Point(
                                new Random().nextInt(
                                        Game.DISP_W / 10) + Game.DISP_W / 10,
                                new Random().nextInt(
                                        Game.DISP_H / 10) + Game.DISP_H /10));

                fires.get(i).setSize(
                        new Random().nextInt(
                                Game.DISP_W / 10)+50);

            } else if (i == 1) {
                fires.get(i).setLocation(
                        new Point(
                                new Random().nextInt(
                                        Game.DISP_W / 10) + (6 * Game.DISP_W / 10),
                                new Random().nextInt(
                                        Game.DISP_H / 10) + Game.DISP_H / 10));

                fires.get(i).setSize(
                        new Random().nextInt(
                                Game.DISP_W / 10)+75);
            } else {
                fires.get(i).setLocation(
                        new Point(
                                new Random().nextInt(
                                        Game.DISP_W / 2) + Game.DISP_W / 10,
                                new Random().nextInt(
                                        Game.DISP_H / 10) + (7 * Game.DISP_H / 10)));

                fires.get(i).setSize(
                        new Random().nextInt(
                                Game.DISP_W / 10)+100);
            }
        }
        increment = 0;
    }

    void init() {
        new Game().show();
    }

    public void quit() {

        Display.getInstance().exitApplication();
    }


    public void leftArrowPressed() {
        helicopter.steer(false);
    }

    public void rightArrowPressed(){
        helicopter.steer(true);
    }

    public void upArrowPressed(){
        helicopter.changeSpeed(true);
    }

    public void downArrowPressed(){
        helicopter.changeSpeed(false);
    }

    public void drinkWater(){
        if (helicopter.collidesWithRiver(river)) {
            helicopter.drinkWater();
        }
    }

    public void fightFire(){
        for (Fire fire: fires) {
            helicopter.fight(fire);
        }
    }

    public void draw(Graphics g) {
        g.clearRect(0,0, Game.DISP_W, Game.DISP_H);
        helicopter.draw(g);
        river.draw(g);
        helipad.draw(g);
        for (Fire fire : fires) {
            fire.draw(g);
        }
        tick();
        g.setFont(Font.createSystemFont(CN.FACE_MONOSPACE,
                CN.STYLE_PLAIN,
                CN.SIZE_MEDIUM));
    }

    public void tick() {

        //if all fires out and speed is 0
        //and resting on helipad you win
        if (allFiresOut(fires) && helicopter.getSpeed() == 0 && landCopter()) {
            //victory condition
            //ask to play again or quit
            if(Dialog.show("You win",
                    "Your score: " + helicopter.getFuel(),
                    "Play again", "Quit")){
                init();
            }else{
                quit();
            }

            //if you run out of fuel you lose
        } else if (helicopter.getFuel() <= 0) {
            //defeat
            //ask to play again or quit

            if(Dialog.show("Game over",
                    "Play Again?",
                    "Yes",
                    "No")){
                init();
            }else{
                quit();
            }
        } else {

            //else grow the fires by random amount 1-5
            //
            for(int i = 0; i < NUMBER_OF_FIRES; i ++) {
                int randomSize = 0;
                randomSize = new Random().nextInt(3);
                if (increment % 9 == 0) {
                    fires.get(0).setSize(fires.get(0).getSize() + randomSize);
                } else if (increment % 10 == 0) {
                    fires.get(1).setSize(fires.get(1).getSize() + randomSize);
                } else if (increment % 11 == 0){
                    fires.get(2).setSize(fires.get(2).getSize() + randomSize);
                }
            }
        }

        //move around
        helicopter.walk();
        increment++;
    }
    public boolean landCopter(){
        Point copter = helicopter.getLocation();
        Point pad = helipad.getLocation();
        int pWidth = Game.DISP_W/10;
        int pLength = Game.DISP_W/10;

        //this conditional makes sure the location of the helicopter is
        //within the helipad
        //if copter.getX is > pad.getX but less than pad.getX + its width
        //and copter.getY is > pad.getY but less than pad.getY + its length
        if((copter.getX() > pad.getX()
                && copter.getX() < (pad.getX() + pWidth))
                && copter.getY() > pad.getY()
                && copter.getY() < pad.getY() + pLength){
            return true;
        }
        return false;
    }

    public boolean allFiresOut(ArrayList<Fire> fires) {
        for(Fire fire: fires) {
            if(fire.getSize() > 0) {
                return false;
            }
        }
        return true;
    }

}

