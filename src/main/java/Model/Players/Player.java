package Model.Players;

import Model.DiceLogic.DiceConfigurations.Configuration;
import Model.DiceLogic.EvaluationAlgorithm.DiceEvaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Player {
    public final String PLAYER_NAME;
    private final List<Integer> playerDice;
    private int rank;
    private Configuration figure;

    public Player(String name) {
        this.PLAYER_NAME = name;
        this.playerDice = new ArrayList<>();
        this.rank = 0;
        this.figure = null;
    }
    //Abstract method
    abstract public void decision(List<Integer> list);

    //Shared methods

    public void initialThrowOfFiveDice(){
        for(int i =0; i<5; i++){
            playerDice.add(throwDice());
        }
        updateRank();
    }
    public int throwDice(){
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    protected void updateRank(){
        Configuration newConfiguration = DiceEvaluation.evaluate(this.getPlayerDice());
        this.setFigure(newConfiguration);
    }
    public void setFigure(Configuration figure) {
        this.figure = figure;
        this.rank = figure.setRank();
    }

    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    public List<Integer> getPlayerDice() {
        return playerDice;
    }

    public int getRank() {
        return rank;
    }

    public Configuration getFigure() {
        return figure;
    }



}
