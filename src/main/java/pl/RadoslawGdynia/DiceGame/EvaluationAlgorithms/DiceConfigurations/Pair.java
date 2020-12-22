package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class Pair implements Configuration {
    private final String NAME = "Pair";
    public static final int BASE_VALUE = 10;
    private int finalValue;

    public Pair(int modifier) {
        this.finalValue = BASE_VALUE+modifier;
    }

    public Pair() {
    }

    @Override
    public int setRank() {
        return finalValue;
    }
    @Override
    public String returnName() {
        return NAME;
    }
}
