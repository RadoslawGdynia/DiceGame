package pl.RadoslawGdynia.DiceGame.Player;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations.Configuration;
import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceEvaluation;

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

    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    public List<Integer> getPlayerDice() {
        return playerDice;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.figure.setRank();
    }

    public Configuration getFigure() {
        return figure;
    }

    public void setFigure(Configuration figure) {
        this.figure = figure;
        this.rank = figure.setRank();
    }
    public void initialThrow(){
        for(int i =0; i<5; i++){
            playerDice.add(throwDice());
        }
        this.setFigure(DiceEvaluation.evaluate(playerDice));
    }
    public int throwDice(){
        Random random = new Random();
        return random.nextInt(5) + 1;
    }
    abstract public void decision(List<Integer> list);
}
