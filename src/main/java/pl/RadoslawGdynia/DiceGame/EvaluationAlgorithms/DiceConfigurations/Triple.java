package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class Triple implements Configuration {
    private final String NAME = "Three Of A Kind";
    public static final int BASE_VALUE = 35;
    private int finalValue;

    public Triple(int modifier) {
        this.finalValue = BASE_VALUE+modifier;
    }
    public Triple() {
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
