package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class LargeStraight implements Configuration {

    private final String NAME = "Large Straight";
    public static final int BASE_VALUE = 55;
    private int finalValue;

    public LargeStraight(int modifier) {
        this.finalValue = BASE_VALUE+modifier;
    }

    public LargeStraight() {
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
