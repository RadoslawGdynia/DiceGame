package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class Pair implements Configuration {
    private final String NAME = "Pair";
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
