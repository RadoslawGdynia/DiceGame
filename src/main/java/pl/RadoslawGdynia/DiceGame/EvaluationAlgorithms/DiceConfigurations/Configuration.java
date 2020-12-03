package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

import java.util.ArrayList;

public interface Configuration {
    int setRank();
    boolean checkForPresence(ArrayList<Integer> results);
    String returnName();
}
