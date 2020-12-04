package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class Tripple implements Configuration {
    private final String NAME = "Three Of A Kind";
    private int weight;
    @Override
    public int setRank() {
        return 20+weight;
    }
    @Override
    public String returnName() {
        return NAME;
    }
}
