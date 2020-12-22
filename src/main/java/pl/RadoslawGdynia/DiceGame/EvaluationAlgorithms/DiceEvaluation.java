package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations.*;

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
        int firstModifier =6-resultData.indexOf(highestMultiple);
        int secondModifier = 6-resultData.indexOf(secondHighestMultiple);

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

    protected static List<Integer> configurationEvaluation(List<Integer> results) {
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

    public static void showDice(List<Integer> dice) {
        for (Integer i : dice) System.out.print(i + ", ");
        System.out.println();
    }
}
