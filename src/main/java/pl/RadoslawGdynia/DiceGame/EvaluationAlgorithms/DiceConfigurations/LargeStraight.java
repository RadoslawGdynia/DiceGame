package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class LargeStraight implements Configuration {

    private final String NAME = "Large Straight";
    @Override
    public int setRank() {
        return 60;
    }

    @Override
    public String returnName() {
        return NAME;
    }
}
