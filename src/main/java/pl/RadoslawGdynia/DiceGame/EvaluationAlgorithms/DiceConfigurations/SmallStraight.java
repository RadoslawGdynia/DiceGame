package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class SmallStraight implements Configuration {
    private final String NAME = "Small Straight";
    @Override
    public int setRank() {
        return 40;
    }

    @Override
    public String returnName() {
        return NAME;
    }
}
