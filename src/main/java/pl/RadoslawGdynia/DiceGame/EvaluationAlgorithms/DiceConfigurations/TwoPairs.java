package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class TwoPairs implements Configuration {
    private final String NAME = "Two pairs";
    private int weight;
    @Override
    public int setRank() {
        return weight;
    }

    @Override
    public String returnName() {
        return NAME;
    }
}
