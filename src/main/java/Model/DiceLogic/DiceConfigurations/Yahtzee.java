package Model.DiceLogic.DiceConfigurations;

public class Yahtzee implements Configuration {
    private final String NAME = "YAHTZEE";
    public static final int BASE_VALUE = 120;
    private final int finalValue;

    public Yahtzee(int modifier) {
        this.finalValue = BASE_VALUE+5*modifier;
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
