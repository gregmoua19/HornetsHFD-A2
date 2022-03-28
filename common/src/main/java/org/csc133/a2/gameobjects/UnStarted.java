package org.csc133.a2.gameobjects;

public class UnStarted extends Fire2{
    private static UnStarted instance = new UnStarted();

    private UnStarted(){};

    public static UnStarted getUnstarted() {
        return instance;
    }

    public static void message() {
        System.out.println("I am unstarted.");
    }

    @Override
    public void updateState(Fire2 fire) {
    }
}
