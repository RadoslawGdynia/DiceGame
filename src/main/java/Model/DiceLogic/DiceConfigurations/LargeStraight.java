package Model.DiceLogic.DiceConfigurations;

public class LargeStraight implements Configuration {

    private final String NAME = "Large Straight";
    public static final int BASE_VALUE = 55;
    private final int finalValue;

    public LargeStraight(int modifier) {
        this.finalValue = BASE_VALUE+modifier;
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
