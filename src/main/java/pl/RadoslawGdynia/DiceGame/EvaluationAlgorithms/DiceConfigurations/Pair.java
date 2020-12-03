package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

import java.util.ArrayList;

public class Pair implements Configuration {
    private final String NAME = "Pair";
    @Override
    public int setRank() {
        return 0;
    }

    @Override
    public String returnName() {
        return NAME;
    }

    @Override
    public boolean checkForPresence(ArrayList<Integer> results) {
        return false;
    }
}
