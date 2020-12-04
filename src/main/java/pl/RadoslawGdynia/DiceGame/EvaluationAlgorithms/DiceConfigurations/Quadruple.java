package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class Quadruple implements Configuration {
    private final String NAME = "Four Of A Kind";
    @Override
    public int setRank() {
        return 80;
    }

    @Override
    public String returnName() {
        return NAME;
    }
}
