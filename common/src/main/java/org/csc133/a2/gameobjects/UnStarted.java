package org.csc133.a2.gameobjects;

public class UnStarted implements FireState{
    private static UnStarted instance = new UnStarted();

    private UnStarted(){};

    public static UnStarted instance() {
        System.out.println("Unstarted");
        return instance;
    }

    public static void message() {
        System.out.println("I am unstarted.");
    }

    @Override
    public void updateState(Fire fire) {
        System.out.println("Unstarted now burning");
        fire.setState(Burning.instance());
    }
}