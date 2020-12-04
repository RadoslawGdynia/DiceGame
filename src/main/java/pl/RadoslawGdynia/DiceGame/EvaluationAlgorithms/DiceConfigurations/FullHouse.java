package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations;

public class FullHouse implements Configuration {
    private final String name = "Full House";
    @Override
    public int setRank() {
        return 70;
    }

    @Override
    public String returnName() {
        return name;
    }
}
