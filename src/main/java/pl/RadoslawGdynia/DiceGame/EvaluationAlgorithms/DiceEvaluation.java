package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DiceEvaluation {

    public DiceEvaluation() {
    }
    public static Configuration evaluate(List<Integer> results){
        List<Integer> resultData = configurationEvaluation(results);
        List<Integer> weightedResults = new ArrayList<>(resultData);
        weightedResults.sort(Integer::compareTo);
        Collections.reverse(weightedResults);
        if(weightedResults.get(0)==5) return new Yahtzee();
        else if (weightedResults.get(0)==4) return new Quadruple();
        else if(weightedResults.get(0)==3){
            if(weightedResults.get(1)==2){
                return new FullHouse();
            } else {
                return new Tripple();
            }
        }
        else if( weightedResults.get(0)==2){
            if(weightedResults.get(1)==2){
                return new TwoPairs();
            }
            else return new Pair();
        }
        else {
            if(resultData.get(0)==0 || resultData.get(4)==0){
                return new LargeStraight();
            } else if(resultData.get(0)==0 && resultData.get(4)==0 ||
                    (resultData.get(3)==0 && resultData.get(4)==0) ||
                    resultData.get(0)==0 && resultData.get(1)==0) return new SmallStraight();
        }
        return new Nothing();
    }

    protected static List<Integer> configurationEvaluation(List<Integer> results){
        List<Integer> toEvaluate = results.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> configuration = new ArrayList<>();
        for (int i =0; i<6; i++){
            configuration.add(0);
        }
        int index = 0;
        for(Integer dice : toEvaluate){
            for(int i = 6; i>0; i--){
                if(dice==i) configuration.set(index, configuration.get(index)+1);
                else index++;
            }
            index = 0;
        }
        return configuration;
    }
    public static void showDice(List<Integer> dice) {
        for(Integer i : dice) System.out.print(i+ ", ");
        System.out.println();
    }
}
