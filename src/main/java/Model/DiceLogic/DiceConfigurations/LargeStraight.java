package Model.DiceLogic.DiceConfigurations;

public class LargeStraight implements Configuration {

    private final String NAME = "Large Straight";
    public static final int BASE_VALUE = 55;
    private final int finalValue;

    public LargeStraight(int modifier) {
        if (ValueCheck.isInCorrectRange(modifier))  this.finalValue = BASE_VALUE+modifier;
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
