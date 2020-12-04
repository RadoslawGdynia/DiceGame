package pl.RadoslawGdynia.DiceGame.Player;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Player {
    public final String PLAYER_NAME;
    private final List<Integer> result;
    private int rank;
    private Configuration figure;

    public Player(String name) {
        this.PLAYER_NAME = name;
        this.result = new ArrayList<>();
        this.rank = 0;
        this.figure = null;
    }

    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    public List<Integer> getResult() {
        return result;
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
            result.add(throwDice());
        }
    }

    public int throwDice(){
        Random random = new Random();
        return random.nextInt(5) + 1;
    }
    abstract void decision();
}
