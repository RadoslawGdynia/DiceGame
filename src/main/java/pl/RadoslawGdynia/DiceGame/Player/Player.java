package pl.RadoslawGdynia.DiceGame.Player;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations.Configuration;

import java.util.List;

public class Player {
    public final String PLAYER_NAME;
    private final List<Integer> result;
    private int rank;
    private Configuration figure;

    public Player(String name, List<Integer> result) {
        this.PLAYER_NAME = name;
        this.result = result;
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
    }
}
