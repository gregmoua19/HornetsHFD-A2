package org.csc133.a2.gameobjects;

public class Burning implements FireState {

    private static Burning instance = new Burning();

    private Burning(){}

    public static Burning instance(){
        System.out.println("I am now burning");
        return instance;
    }

    @Override
    public void updateState(Fire fire) {
        System.out.println("Burning to extinguished");
        fire.setState(Extinguished.instance());
    }

}

