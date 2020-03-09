package edu.up.cs301.pig;

import android.os.Handler;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class PigGameState extends GameState {
    private int playerID;
    private int p0Score;
    private int p1Score;
    private int total;
    private int dieVal;
    private int playerCount = 2;

    public PigGameState() {

    }
    public  PigGameState(PigGameState stateToCopy){
        playerID = stateToCopy.getPlayerID();
        p0Score = stateToCopy.getP0Score();
        p1Score = stateToCopy.getP1Score();
        total = stateToCopy.getTotal();
        dieVal = stateToCopy.getDieVal();
    }

    public int getPlayerID(){
        return playerID;
    }

    public int getP0Score(){
        return p0Score;
    }

    public int getP1Score(){
        return p1Score;
    }

    public int getTotal(){
        return total;
    }
    public int getDieVal(){
        return dieVal;
    }
    public void setPlayerID(int playerID){
        this.playerID = playerID;
    }
    public void setP0Score(int p0Score){
        this.p0Score = p0Score;
    }
    public void setP1Score(int p1Score){
        this.p1Score = p1Score;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public void setDieVal(int dieVal){
        this.dieVal = dieVal;
    }
    public int getPlayerCount(){
        return playerCount;
    }
    public void setPlayerCount(int playerCount){
        this.playerCount = playerCount;
    }

}

