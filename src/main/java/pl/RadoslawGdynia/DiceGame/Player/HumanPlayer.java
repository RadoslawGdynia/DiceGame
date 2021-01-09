package pl.RadoslawGdynia.DiceGame.Player;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceEvaluation;

import java.util.List;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }
    public void decision(List<Integer> list){
        if(list.isEmpty()) return;
        for(Integer index : list){
            int replacement = super.throwDice();
            this.getPlayerDice().set(index, replacement);
        }
        this.setFigure(DiceEvaluation.evaluate(this.getPlayerDice()));
    }
}
