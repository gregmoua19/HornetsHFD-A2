package org.csc133.a2.gameobjects;

public class Extinguished extends Fire2{

    private static Extinguished instance = new Extinguished();

    private Extinguished() {};

    public static Extinguished getExtinguished(){
        return instance;
    }

    public void message() {
        System.out.println("I have been extinguished");
    }

    @Override
    public void updateState(Fire2 fire) {

    }
}
