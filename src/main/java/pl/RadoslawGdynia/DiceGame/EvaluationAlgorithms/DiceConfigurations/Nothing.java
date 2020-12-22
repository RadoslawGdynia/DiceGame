package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class Nothing implements Configuration {
    private static final String NAME = "Nothing";
    public static final int BASE_VALUE = 0;

    @Override
    public int setRank() {
        return 0;
    }

    @Override
    public String returnName() {
        return NAME;
    }

}
