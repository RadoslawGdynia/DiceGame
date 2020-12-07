package pl.RadoslawGdynia.DiceGame.Player;

import java.util.List;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }
    public void decision(List<Integer> list){
        if(list.isEmpty()) return;
        for(Integer index : list){
            int replacement = super.throwDice();
            this.getResult().set(index, replacement);
        }
    }
}
