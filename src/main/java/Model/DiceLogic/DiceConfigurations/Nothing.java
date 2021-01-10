package Model.DiceLogic.DiceConfigurations;

public class Nothing implements Configuration {
    private static final String NAME = "Nothing";

    @Override
    public int setRank() {
        return 0;
    }

    @Override
    public String returnName() {
        return NAME;
    }

}
