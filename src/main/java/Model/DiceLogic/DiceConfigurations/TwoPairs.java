package Model.DiceLogic.DiceConfigurations;

public class TwoPairs implements Configuration {
    private final String NAME = "Two pairs";
    public static final int BASE_VALUE = 20;
    private final int finalValue;

    public TwoPairs(int firstModifier, int secondModifier) {
        if (ValueCheck.isInCorrectRange(firstModifier, secondModifier))  this.finalValue = BASE_VALUE+firstModifier+secondModifier;
        else throw new IllegalArgumentException("Dice can have values of 1-6");
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
