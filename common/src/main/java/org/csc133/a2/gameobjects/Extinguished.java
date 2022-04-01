package org.csc133.a2.gameobjects;

public class Extinguished implements FireState{

    private static Extinguished instance = new Extinguished();

    private Extinguished() {};

    public static Extinguished instance(){
        System.out.println("I am now extinguished");
        return instance;
    }

    public void message() {
        System.out.println("I have been extinguished");
    }

    @Override
    public void updateState(Fire fire) {
        System.out.println("Extinguished to ??? ");
    }
}
