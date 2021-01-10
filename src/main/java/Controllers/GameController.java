package Controllers;

import Model.Players.Player;

public interface GameController {
    void implementRoundChanges(Player activePlayer);
    void showFinalResults();
}
