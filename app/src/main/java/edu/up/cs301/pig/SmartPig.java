package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;

public class SmartPig extends GameComputerPlayer {

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public SmartPig(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        PigGameState pig = (PigGameState)info;
        if(pig.getPlayerID()==super.playerNum){
            int score1 = (super.playerNum==1)? pig.getP1Score() : pig.getP0Score();
            int score2 = (super.playerNum == 1)? pig.getP0Score() : pig.getP1Score();
            GameAction acti = (pig.getTotal()<10 || score1+pig.getTotal()<score2-10? new PigRollAction(this) :new PigHoldAction(this));
            super.game.sendAction(acti);
        }
return;
    }
}
