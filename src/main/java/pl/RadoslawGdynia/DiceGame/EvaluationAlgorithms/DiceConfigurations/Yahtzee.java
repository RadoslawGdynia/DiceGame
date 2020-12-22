package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class Yahtzee implements Configuration {
    private final String NAME = "YAHTZEE";
    public static final int BASE_VALUE = 120;
    private int finalValue;

    public Yahtzee(int modifier) {
        this.finalValue = BASE_VALUE+5*modifier;
    }
    public Yahtzee() {
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
