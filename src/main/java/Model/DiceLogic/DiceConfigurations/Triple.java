package Model.DiceLogic.DiceConfigurations;

public class Triple implements Configuration {
    private final String NAME = "Three Of A Kind";
    public static final int BASE_VALUE = 35;
    private final int finalValue;

    public Triple(int modifier) {
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
