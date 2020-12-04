package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class Yahtzee implements Configuration {
    private final String NAME = "YAHTZEE";
    @Override
    public int setRank() {
        return 100;
    }
    @Override
    public String returnName() {
        return NAME;
    }
}
