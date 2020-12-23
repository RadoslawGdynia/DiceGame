package pl.RadoslawGdynia.DiceGame.Player;

import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceEvaluation;
import pl.RadoslawGdynia.DiceGame.Main.Main;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name){
        super(name);
    }
    public void decision(List<Integer> list){
        List<Integer> indicesToReRoll = new ArrayList<>();
        int humanPlayerRank = Main.getPlayers().get(0).getRank();
        int computerPlayerRank = this.getRank();
        if(computerPlayerRank<humanPlayerRank){
            List<Integer> dice = DiceEvaluation.configurationEvaluation(this.getResult());
            int figureValue1 = dice.indexOf(3);
            if(figureValue1>=0){
                for(int i =0; i<this.getResult().size(); i++){
                    if(this.getResult().get(i)!=(6-figureValue1)) indicesToReRoll.add(i);
                }
            } else {
                int figureValue2 = dice.indexOf(2);
                int figureValue3 = dice.lastIndexOf(2);
                for(int i =0; i<this.getResult().size(); i++){
                    if(this.getResult().get(i) != (6-figureValue2) &&
                            this.getResult().get(i) != (6-figureValue3)) indicesToReRoll.add(i);
                }
            }
        }
        for(Integer index : indicesToReRoll){
            int replacement = super.throwDice();
            this.getResult().set(index, replacement);
        }
    }
}
