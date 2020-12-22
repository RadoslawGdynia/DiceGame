package pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations.*;
import pl.RadoslawGdynia.DiceGame.Main.Main;
import pl.RadoslawGdynia.DiceGame.Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResultEvaluation {

    public static List<Integer> computerDecisionAlgorithm(){

        List<Integer> indexesToReRoll = new ArrayList<>();
        Player computer = Main.getPlayers().get(1);
        List<Integer> computerDices = computer.getResult();
        int humanPlayerRank = Main.getPlayers().get(0).getRank();
        if(computer.getRank()>humanPlayerRank) return null;
        else {
            List<Integer> computerSorted = DiceEvaluation.configurationEvaluation(computerDices);
            int highestMultiple = computerSorted.get(0);
            Map<Integer, Configuration> possibleConfigurations = new TreeMap<>();
            possibleConfigurations.put(10, new Pair());
            possibleConfigurations.put(20, new TwoPairs());
            possibleConfigurations.put(35, new Triple());
            possibleConfigurations.put(45, new SmallStraight());
            possibleConfigurations.put(55, new LargeStraight());
            possibleConfigurations.put(60, new FullHouse());
            possibleConfigurations.put(90, new Quadruple());
            possibleConfigurations.put(120, new Yahtzee());
        }
        return indexesToReRoll;
    }

    public static String finalResult(){
        Player p1 = Main.getPlayers().get(0);
        Player p2 = Main.getPlayers().get(1);
        return (p1.getRank()>p2.getRank())? p1.getPLAYER_NAME() : p2.getPLAYER_NAME();
    }
}
