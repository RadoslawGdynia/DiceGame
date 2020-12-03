package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

import java.util.ArrayList;

public class FullHouse implements Configuration {
    private final String name = "Full House";
    @Override
    public int setRank() {
        return 0;
    }

    @Override
    public boolean checkForPresence(ArrayList<Integer> results) {
        return false;
    }

    @Override
    public String returnName() {
        return name;
    }
}
