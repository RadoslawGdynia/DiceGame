package Model.DiceLogic.DiceConfigurations;

public class SmallStraight implements Configuration {
    private final String NAME = "Small Straight";
    public static final int BASE_VALUE = 45;
    private final int finalValue;

    public SmallStraight(int modifier) {
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
