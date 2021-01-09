package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations.*;
import pl.RadoslawGdynia.DiceGame.Model.DiceGameModel;
import pl.RadoslawGdynia.DiceGame.Player.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DiceEvaluation {

    public DiceEvaluation() {
    }

    public static Configuration evaluate(List<Integer> results) {
        List<Integer> resultData = configurationEvaluation(results);
        List<Integer> weightedResults = resultData.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());


        int highestMultiple = weightedResults.get(0);
        int secondHighestMultiple = weightedResults.get(1);
        int firstModifier = 6 - resultData.indexOf(highestMultiple);
        int secondModifier = 6 - resultData.indexOf(secondHighestMultiple);

        switch (highestMultiple) {
            case 5:
                return new Yahtzee(firstModifier);
            case 4:
                return new Quadruple(firstModifier);
            case 3:
                if (secondHighestMultiple == 2) {
                    return new FullHouse(firstModifier, secondModifier);
                } else {
                    return new Triple(firstModifier);
                }
            case 2:
                if (secondHighestMultiple == 2) {
                    return new TwoPairs(firstModifier, secondModifier);
                } else return new Pair(firstModifier);
            case 1:
                if (resultData.get(0) == 0 || resultData.get(4) == 0) {
                    return new LargeStraight(firstModifier);
                } else if (resultData.get(0) == 0 && resultData.get(4) == 0 ||
                        (resultData.get(3) == 0 && resultData.get(4) == 0) ||
                        resultData.get(0) == 0 && resultData.get(1) == 0) return new SmallStraight(firstModifier);

            default:
                return new Nothing();
        }
    }

    public static List<Integer> configurationEvaluation(List<Integer> results) {
        List<Integer> toEvaluate = results.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> configuration = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            configuration.add(0);
        }
        int index = 0;
        for (Integer dice : toEvaluate) {
            for (int i = 6; i > 0; i--) {
                if (dice == i) configuration.set(index, configuration.get(index) + 1);
                else index++;
            }
            index = 0;
        }
        return configuration;
    }

    public static String finalResult() {
        Player p1 = DiceGameModel.getPlayers().get(0);
        Player p2 = DiceGameModel.getPlayers().get(1);
        if (p1.getRank() == p2.getRank()) return "both of you. However unlikely it was a draw!";
        return (p1.getRank() > p2.getRank()) ? p1.getPLAYER_NAME() : p2.getPLAYER_NAME();
    }
}
