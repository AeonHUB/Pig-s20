package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState ya;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        ya = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {

        if(playerIdx == ya.getPlayerID()){
            return true;
        }


        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof PigRollAction){
            Random ran = new Random();
            int i = ran.nextInt(6) +1;
            ya.setDieVal(i);
            if( i != 1){
                ya.setTotal(ya.getTotal()+i);

            }
            else{
                ya.setTotal(0);
                if(ya.getPlayerCount() > 1){
                    ya.setPlayerID(1 - ya.getPlayerID());

                }

            }
            return true;

        }
        if(action instanceof PigHoldAction){
            if(ya.getPlayerID() == 1){
                ya.setP1Score(ya.getP1Score() + ya.getTotal());
            }
            else{
                ya.setP0Score(ya.getP0Score() + ya.getTotal());
            }
            ya.setTotal(0);
            if(ya.getPlayerCount() > 1){
                ya.setPlayerID(1 - ya.getPlayerID());
            }
            return true;
        }
        else{
            return false;
        }

    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState temp = new PigGameState(ya);
        p.sendInfo(temp);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(ya.getP0Score() >= 50){
            return("Player 1 won with score of: " + ya.getP0Score());
        }
        else if (ya.getPlayerCount() > 1){
            if(ya.getP1Score() >= 50){
                return("Player 2 won with score of: " + ya.getP1Score());
            }

        }
        return null;
    }

}// class PigLocalGame
