package org.csc133.a2;

import com.codename1.ui.*;
import com.codename1.ui.geom.Point;
import org.csc133.a2.gameobjects.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameWorld {
    private ArrayList<GameObject> allGameObjects;
    //private final int NUMBER_OF_FIRES = 3;
    private Helicopter helicopter;
    private ArrayList<Fire> fires;
    private ArrayList<Building> buildings;
    private Helipad helipad;
    private River river;
    private int increment;

    //constructor to make and then add everything to items
    public GameWorld(){
        helicopter = new Helicopter();
        helipad = new Helipad();
        river = new River();
        fires = new ArrayList<Fire>();
        buildings = new ArrayList<Building>();

        allGameObjects = new ArrayList<>();

        allGameObjects.add(helicopter);
        allGameObjects.add(helipad);
        allGameObjects.add(river);
        for(Fire fire: fires) {
            allGameObjects.add(fire);
        }
        for(Building building: buildings) {
            allGameObjects.add(building);
        }
        //add buildings

        //add fires
    }

    void init() {
        new Game().show();
    }

    public void quit() {
        Display.getInstance().exitApplication();
    }

/*
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
 */

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


    public ArrayList<GameObject> getGameObjectCollection(){
        return allGameObjects;
    }

    public String getHeading() {
        return String.valueOf(helicopter.getHeading());
    }

    public String getSpeed() {
        return String.valueOf(helicopter.getSpeed());
    }

    public String getFuel() {
        return String.valueOf(helicopter.getFuel());
    }

    public String getFires() {
        int counter = 0;
        for (GameObject go : allGameObjects) {
            if (go.toString() == "Fire") {
                counter++;
            }
        }
        return String.valueOf(counter);
    }

    public String getFireSize() {
        int counter = 0;
        for (GameObject go : allGameObjects) {
            if (go.toString() == "Fire") {
                counter += go.getSize();
            }
        }
        return String.valueOf(counter);
    }

    public String getDamage() {
        return "0";
    }

    public String getLoss() {
        return "0";
    }

    public Helicopter getHelicopter() {
        return helicopter;
    }
}

