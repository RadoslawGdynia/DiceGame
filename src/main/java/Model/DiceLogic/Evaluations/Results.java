package Model.DiceLogic.Evaluations;

import Model.Players.Player;

public class Results {

    public static String finalResult(Player p1, Player p2) {
        if (p1.getRank() == p2.getRank()) return "both of you. However unlikely it was a draw!";
        return (p1.getRank() > p2.getRank()) ? p1.getPLAYER_NAME() : p2.getPLAYER_NAME();
    }
}
