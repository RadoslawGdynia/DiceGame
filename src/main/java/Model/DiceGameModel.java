package Model;

import Controllers.GameController;
import Model.DiceLogic.Evaluations.Results;
import Model.Players.ComputerPlayer;
import Model.Players.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.List;
import java.util.Optional;

public class DiceGameModel  {

    private static List<Player> players;
    private static boolean computerAsOpponent;

    private final GameController controller;
    private Player activePlayer;
    private int round = 0;


    public DiceGameModel(GameController controller) {
        this.controller = controller;
        activePlayer = players.get(0);
        computerAsOpponent = players.get(1) instanceof ComputerPlayer;
    }

    public static void setPlayers(List<Player> player) {
        players = player;
    }
    public boolean computerIsOpponent(){
        return computerAsOpponent;
    }

    public String[] providePlayersNames(){
        return new String[]{players.get(0).getPLAYER_NAME(), players.get(1).getPLAYER_NAME()};
    }

    public void clearPlayersScore(){
        for(Player p : players){
            p.getPlayerDice().clear();
        }
    }

    public String provideWinnerName(){
        Player p1 = players.get(0);
        Player p2 = players.get(1);
        return Results.finalResult(p1, p2);
    }

    public static int provideHumanScore(){
        return players.get(0).getRank();
    }

    public void playButtonLogic(List<Integer> diceToReRoll) {
        if(round<2) firstRoundPhase();
        else reRollPhase(diceToReRoll);
        if(round==4) controller.showFinalResults();
    }

    // ========== playButtonLogic sub-methods ==========

    private void firstRoundPhase() {
        activePlayer.initialThrowOfFiveDice();
        changeActivePlayerUpdateGameStatus();
        if(computerAsOpponent) {
            activePlayer.initialThrowOfFiveDice();
            changeActivePlayerUpdateGameStatus();
        }
    }
    private void reRollPhase(List<Integer> diceToReRoll) {

        if (diceToReRoll.isEmpty()) {
            Optional<ButtonType> playerDecision = showNoDiceSelectedAlert();
            continueOrChangeDecision(playerDecision, diceToReRoll);
        } else {
            activePlayer.decision(diceToReRoll);
        }
        changeActivePlayerUpdateGameStatus();
        if (computerAsOpponent) {
            activePlayer.decision(diceToReRoll);
            changeActivePlayerUpdateGameStatus();
        }
    }

    // ========== reRollPhase sub-methods ==========

    private Optional<ButtonType> showNoDiceSelectedAlert(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("You decided not to re-roll any dice.");
        alert.setContentText("If you want to proceed press OK,\n if you would like to select dices to re-roll press CANCEL");
        return alert.showAndWait();
    }

    private void continueOrChangeDecision(Optional<ButtonType> playerDecision, List<Integer> diceToReRoll){
        if (playerDecision.isPresent() && playerDecision.get() == ButtonType.OK) activePlayer.decision(diceToReRoll);
    }

    private void changeActivePlayerUpdateGameStatus() {
        controller.implementRoundChanges(activePlayer);
        activePlayer = (activePlayer == players.get(0)) ? players.get(1) : players.get(0);
        round++;
    }




}
