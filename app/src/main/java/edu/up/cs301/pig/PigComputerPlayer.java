package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.utilities.Tickable;
import edu.up.cs301.game.R;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {

        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        if(info instanceof PigGameState){
            PigGameState ya = (PigGameState)info;
            if(ya.getPlayerID() == playerNum){
                Random ran = new Random();
                int choice = ran.nextInt(2);
                if(choice == 0){
                    PigHoldAction l = new PigHoldAction(this);
                    game.sendAction(l);
                }else
                    {
                    PigRollAction f = new PigRollAction(this);
                    game.sendAction(f);
                }
            }

        }else{
            return;
        }

    }//receiveInfo

}
