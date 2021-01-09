package pl.RadoslawGdynia.DiceGame.Controllers;

import pl.RadoslawGdynia.DiceGame.Player.Player;

public interface GameController {
    void implementRoundChanges(Player activePlayer);
    void showFinalResults();
}
