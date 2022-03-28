package org.csc133.a2;

import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.gameobjects.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    private int NUMBER_OF_BUILDINGS;
    private int NUMBER_OF_FIRES;

    //constructor to make and then add everything to items
    public GameWorld(){
        NUMBER_OF_BUILDINGS = 3;
        Random rand = new Random();
        helicopter = new Helicopter();
        helipad = new Helipad();
        river = new River();
        NUMBER_OF_FIRES = rand.nextInt(7) + 6;
        fires = new ArrayList<>();
        buildings = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_FIRES;i++) {
            System.out.println("init fire loop " + i);
            fires.add(new Fire());
        }
        for(int i = 0; i < NUMBER_OF_BUILDINGS;i++) {
            System.out.println("init building loop " + i);
            buildings.add(new Building());
        }
        int fireCounter = 0;
        System.out.println(buildings.size());
        System.out.println(fires.size());
        allGameObjects = new ArrayList<>();

        allGameObjects.add(helicopter);
        allGameObjects.add(helipad);
        allGameObjects.add(river);

        for(int i = 0; i < NUMBER_OF_BUILDINGS;i++) {
            System.out.println("Building loop executed");
            if(i == 0) {
                buildings.get(i).setPoint(new Point(Game.DISP_W/5, 5*Game.DISP_H/10));
                buildings.get(i).setDim(new Dimension(Game.DISP_W/10, Game.DISP_H/4));
            } else if (i == 1) {
                buildings.get(i).setPoint(new Point(Game.DISP_W/4 , Game.DISP_H/15));
                buildings.get(i).setDim(new Dimension(Game.DISP_W/10, Game.DISP_H/2));
            } else {
                buildings.get(i).setPoint(new Point(3 * Game.DISP_W/5, 4 * Game.DISP_H/9 ));
                buildings.get(i).setDim(new Dimension(Game.DISP_W/9, Game.DISP_H/5));
            }

            allGameObjects.add(buildings.get(i));
        }
        for(int i = 0; i < NUMBER_OF_FIRES;i++) {
            System.out.println("Fire loop executed");
            //if 1/3 fire set in left building
            if(fireCounter < (NUMBER_OF_FIRES / 3) + 1) {
                fires.get(i).setLocation(new Point(rand.nextInt(
                        buildings.get(0).getPoint().getX())+
                        buildings.get(0).getDim().getWidth(),rand.nextInt(
                        buildings.get(0).getPoint().getY())+
                        buildings.get(0).getDim().getHeight()));
            } else if (fireCounter < ((NUMBER_OF_FIRES / 3) * 2) + 1) {
                fires.get(i).setLocation(new Point(rand.nextInt(
                        buildings.get(1).getPoint().getX())+
                        buildings.get(1).getDim().getWidth(),rand.nextInt(
                        buildings.get(1).getPoint().getY())+
                        buildings.get(1).getDim().getHeight()));
            } else {
                fires.get(i).setLocation(new Point(rand.nextInt(
                        buildings.get(2).getPoint().getX())+
                        buildings.get(2).getDim().getWidth(),rand.nextInt(
                        buildings.get(2).getPoint().getY())+
                        buildings.get(2).getDim().getHeight()));
            }

            //else if 2/3 fire set in top  building

            //else set in right building

            fireCounter++;
            allGameObjects.add(fires.get(i));
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
        Point copter = helicopter.getPoint();
        Point pad = helipad.getPoint();
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
        for(GameObject go : allGameObjects) {
            System.out.print(go.toString() + " ");
        }
        System.out.println("");
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

