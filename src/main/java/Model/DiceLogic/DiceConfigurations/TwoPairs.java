package Model.DiceLogic.DiceConfigurations;

public class TwoPairs implements Configuration {
    private final String NAME = "Two pairs";
    public static final int BASE_VALUE = 20;
    private final int finalValue;

    public TwoPairs(int firstModifier, int secondModifier) {
        this.finalValue = BASE_VALUE+firstModifier+secondModifier;
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
