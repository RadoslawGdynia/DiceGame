package Model.DiceLogic.DiceConfigurations;

public class Quadruple implements Configuration {
    private final String NAME = "Four Of A Kind";
    public static final int BASE_VALUE = 90;
    private final int finalValue;

    public Quadruple(int modifier) {
        if (ValueCheck.isInCorrectRange(modifier))  this.finalValue = BASE_VALUE+4*modifier;
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
