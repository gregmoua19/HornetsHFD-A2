package org.csc133.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import org.csc133.a2.GameWorld;
import org.csc133.a2.gameobjects.GameObject;

import java.util.ArrayList;

public class FightCommand extends Command {
    GameWorld gw;
    public FightCommand(GameWorld gw) {
        super("Fight");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {

    }
}
