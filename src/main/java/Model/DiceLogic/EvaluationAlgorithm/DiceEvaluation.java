package Model.DiceLogic.EvaluationAlgorithm;

import Model.DiceLogic.DiceConfigurations.*;
import Model.DiceGameModel;
import Model.Players.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DiceEvaluation {

    public static Configuration evaluate(List<Integer> results) {
        List<Integer> resultData = diceConfigurationEvaluation(results);
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
                return fullHouseOrTriple(secondHighestMultiple, firstModifier, secondModifier);
            case 2:
                return twoPairsOrOnePair(secondHighestMultiple, firstModifier, secondModifier);
            default:
                return smallOrLargeStraightOrNothing(resultData, firstModifier);
        }
    }

    private static Configuration fullHouseOrTriple(int secondHighestMultiple, int firstModifier, int secondModifier){
        if (secondHighestMultiple == 2) {
            return new FullHouse(firstModifier, secondModifier);
        } else {
            return new Triple(firstModifier);
        }
    }
    private static Configuration twoPairsOrOnePair(int secondHighestMultiple, int firstModifier, int secondModifier){
        if (secondHighestMultiple == 2) {
            return new TwoPairs(firstModifier, secondModifier);
        } else return new Pair(firstModifier);
    }
    private static Configuration smallOrLargeStraightOrNothing(List<Integer> resultData, int firstModifier) {
        //Large straight means that 5 dice are in order, which means that either there is no 1 or 6 in results
        if (resultData.get(0) == 0 || resultData.get(4) == 0) {
            return new LargeStraight(firstModifier);
        //Small straight means that 4 dice are in order, which means that there are three possible combinations:
        } else if (resultData.get(0) == 0 && resultData.get(4) == 0 ||
                (resultData.get(3) == 0 && resultData.get(4) == 0) ||
                resultData.get(0) == 0 && resultData.get(1) == 0) return new SmallStraight(firstModifier);
        //If none of the above is true, than there is no combination at all and method returns Nothing:
        return new Nothing();
    }

    //returns number of dice showing each of the possible values in order from 6 to 1
    public static List<Integer> diceConfigurationEvaluation(List<Integer> results) {
        List<Integer> toEvaluate = results.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> configuration = createListForEvaluationResults();
        sumEqualDice(toEvaluate, configuration);
        return configuration;
    }

    //Creates list with 6 arguments, one for each possible value of the dice.
    private static List<Integer> createListForEvaluationResults(){
        List<Integer> configuration = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            configuration.add(0);
        }
        return configuration;
    }

    //Sums how many dice from the result are showing each possible result.
    // Next saves each sum in the list following the descending order of dice values (6-1).
    private static void sumEqualDice(List<Integer> toEvaluate, List<Integer> configuration){
        int index = 0;
        for (Integer dice : toEvaluate) {
            for (int i = 6; i > 0; i--) {
                if (dice == i) configuration.set(index, configuration.get(index) + 1);
                else index++;
            }
            index = 0;
        }
    }

    public static String finalResult() {
        Player p1 = DiceGameModel.getPlayers().get(0);
        Player p2 = DiceGameModel.getPlayers().get(1);
        if (p1.getRank() == p2.getRank()) return "both of you. However unlikely it was a draw!";
        return (p1.getRank() > p2.getRank()) ? p1.getPLAYER_NAME() : p2.getPLAYER_NAME();
    }
}
