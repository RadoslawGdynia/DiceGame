package pl.RadoslawGdynia.DiceGame.Player;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceEvaluation;

import java.util.List;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }
    public void decision(List<Integer> list){
        System.out.println("Before reroll:");
        DiceEvaluation.showDice(this.getResult());
        if(list.isEmpty()) return;
        for(Integer index : list){
            int replacement = super.throwDice();
            this.getResult().set(index, replacement);
        }
        System.out.println("After reroll:");
        DiceEvaluation.showDice(this.getResult());
    }
}
