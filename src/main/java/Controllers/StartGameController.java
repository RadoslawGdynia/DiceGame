package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.DiceGameModel;
import Model.Players.ComputerPlayer;
import Model.Players.HumanPlayer;
import Model.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class StartGameController {

    @FXML
    private Button startButton;
    @FXML
    private TextField player1Name;
    @FXML
    private TextField player2Name;
    @FXML
    private Label player1NameLabel;
    @FXML
    private Label player2NameLabel;

    private boolean computerPlayer;


    public void initialize() {
        player1Name.setDisable(true);
        player2Name.setDisable(true);
        player1NameLabel.setVisible(false);
        player2NameLabel.setVisible(false);
        player1Name.setVisible(false);
        player2Name.setVisible(false);
        startButton.setDisable(true);
    }

    public void handlePlayComputerButton() {
        player1NameLabel.setVisible(true);
        player1Name.setVisible(true);
        player1Name.setDisable(false);
        player2NameLabel.setVisible(false);
        player2Name.setVisible(false);
        player2Name.setDisable(true);
        player2Name.setText("COMPUTER");
        computerPlayer = true;
        startButton.setDisable(false);
    }

    public void handlePlayFriendButton() {
        player1NameLabel.setVisible(true);
        player1Name.setVisible(true);
        player1Name.setDisable(false);
        player2NameLabel.setVisible(true);
        player2Name.setVisible(true);
        player2Name.setDisable(false);
        player2Name.setText("");
        computerPlayer = false;
        startButton.setDisable(false);
    }

    public void handleStartButton() {
        List<Player> players = new ArrayList<>();
        createFirstPlayer(players);
        createSecondPlayer(players);
        DiceGameModel.setPlayers(players);
        closeWindow();
    }
    private void createFirstPlayer(List<Player> players){
        Player player1 = new HumanPlayer(player1Name.getText());
        players.add(player1);
    }
    private void createSecondPlayer(List<Player> players){
        if (computerPlayer) {
            Player computerPlayer = new ComputerPlayer("COMPUTER");
            players.add(computerPlayer);
        } else {
            Player player2 = new HumanPlayer(player2Name.getText());
            players.add(player2);
        }
    }
    private void closeWindow(){
        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.close();
    }

    public void handleExitButton() {
        System.exit(1);
    }
}
