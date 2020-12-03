package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

import java.util.ArrayList;

public class Tripple implements Configuration {
    private final String NAME = "Three Of A Kind";
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
        return NAME;
    }
}
