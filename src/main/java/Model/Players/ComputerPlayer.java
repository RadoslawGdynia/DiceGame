package Model.Players;

import Model.DiceLogic.Evaluations.DiceEvaluation;
import Model.DiceGameModel;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name){
        super(name);
    }
    public void decision(List<Integer> list){
        List<Integer> indicesToReRoll = new ArrayList<>();
        boolean computerIsLoosing = isComputerLoosing();

        chooseDiceToReRoll(computerIsLoosing, indicesToReRoll);
        reRollSelectedDice(indicesToReRoll);
        updateRank();
    }
    private boolean isComputerLoosing(){
        int humanPlayerRank = DiceGameModel.provideHumanScore();
        int computerPlayerRank = this.getRank();
        return computerPlayerRank<humanPlayerRank;
    }

    private void chooseDiceToReRoll(boolean computerIsLoosing, List<Integer> indicesToReRoll){
        if(computerIsLoosing){
            List<Integer> dice = DiceEvaluation.diceConfigurationEvaluation(this.getPlayerDice());

            int indexOfTripledDice = dice.indexOf(3);
            boolean tripleIsPresent = (indexOfTripledDice >= 0);

            if(tripleIsPresent){
                selectDiceOtherThanTriple(indicesToReRoll, indexOfTripledDice);
            } else {
                int indexOfFirstPair = dice.indexOf(2);
                int indexOfLastPair = dice.lastIndexOf(2);
                selectNotDuplicatedDice(indicesToReRoll, indexOfFirstPair, indexOfLastPair);
            }
        }
    }
    private List<Integer> selectDiceOtherThanTriple(List<Integer> indicesToReRoll, int indexOfTripledDice){

        for(int i = 0; i<this.getPlayerDice().size(); i++){
            //To get value tripled dice shows we need to subtract index from maximal value,
            //as evaluated dice are in descending order of possible dice value
            int tripledValue = 6 - indexOfTripledDice;
            int currentDiceValue = this.getPlayerDice().get(i);

            boolean diceNotTripled = (currentDiceValue != tripledValue);
            if(diceNotTripled) indicesToReRoll.add(i);
        }
        return indicesToReRoll;
    }

    private List<Integer> selectNotDuplicatedDice(List<Integer> indicesToReRoll, int indexOfFirstPair, int indexOfLastPair){
        int valueOfFirstPair = 6 - indexOfFirstPair;
        int valueOfLastPair = 6 - indexOfLastPair;

        for(int i = 0; i<this.getPlayerDice().size(); i++){

            int currentDiceValue = this.getPlayerDice().get(i);
            boolean diceIsNotMultiplied = ((currentDiceValue != valueOfFirstPair) &&
                    (currentDiceValue != valueOfLastPair));
            if(diceIsNotMultiplied) indicesToReRoll.add(i);
        }
        return indicesToReRoll;
    }


    private void reRollSelectedDice(List<Integer> indicesToReRoll){
        for(Integer index : indicesToReRoll){
            int replacement = super.throwDice();
            this.getPlayerDice().set(index, replacement);
        }
    }
}
