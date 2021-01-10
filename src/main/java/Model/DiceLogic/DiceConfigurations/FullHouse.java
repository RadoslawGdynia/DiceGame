package Model.DiceLogic.DiceConfigurations;

public class FullHouse implements Configuration {
    private final String name = "Full House";
    public static final int BASE_VALUE = 60;
    private final int finalValue;

    public FullHouse(int firstModifier, int secondModifier) {
        this.finalValue = BASE_VALUE+3*firstModifier+2*secondModifier;
    }

    @Override
    public int setRank() {
        return finalValue;
    }

    @Override
    public String returnName() {
        return name;
    }

}
