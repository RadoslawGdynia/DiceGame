package pl.RadoslawGdynia.DiceGame.Player;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.ResultEvaluation;

import java.util.List;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name){
        super(name);
    }
    public void decision(List<Integer> list){
        List<Integer> indicesToReRoll = ResultEvaluation.computerDecisionAlgorithm();
        if(indicesToReRoll!=null) {
            for(Integer i : indicesToReRoll) {
                this.getResult().set(i, super.throwDice());
            }
        }
    }


}
