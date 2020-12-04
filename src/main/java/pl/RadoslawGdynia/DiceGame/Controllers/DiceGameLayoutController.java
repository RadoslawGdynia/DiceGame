package pl.RadoslawGdynia.DiceGame.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.RadoslawGdynia.DiceGame.DiceTile.DiceTile;
import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations.DiceEvaluation;
import pl.RadoslawGdynia.DiceGame.Main.Main;
import pl.RadoslawGdynia.DiceGame.Player.Player;

import java.util.ArrayList;

public class DiceGameLayoutController {
    public static final Logger log = LoggerFactory.getLogger(DiceGameLayoutController.class);
    @FXML
    private Label p1CommandLabel;
    @FXML
    private Label p2CommandLabel;
    @FXML
    private TilePane p1DicePane;
    @FXML
    private TilePane p2DicePane;
    @FXML
    private Label player1Label;
    @FXML
    private Label player2Label;
    @FXML
    private Button play2Button;
    @FXML
    private Label result1Label;
    @FXML
    private Label result2Label;


    private int round = 1;
    private Player activePlayer;
    private final Player player1 = Main.getPlayers().get(0);
    private final Player player2 = Main.getPlayers().get(1);

    public void initialize() {
        player1Label.setText(player1.getPLAYER_NAME());
        player2Label.setText(player2.getPLAYER_NAME());
        if (player2Label.getText().equals("COMPUTER")) {
            p2CommandLabel.setVisible(false);
            play2Button.setDisable(true);
            play2Button.setVisible(false);

        }
        activePlayer = player1;
    }

    public void handlePlay1Button() {
        if(activePlayer==player1) {
            if (round == 1) {
                player1.initialThrow();
                generateDices((ArrayList<Integer>) player1.getResult());
                player1.setFigure(DiceEvaluation.evaluate(player1.getResult()));
                result1Label.setText("RESULTS:\tFigure you have: " + player1.getFigure().returnName() + " which gives you points: " + player1.getRank());
                activePlayer = player2;
                if (player2.getClass().getSimpleName().equals("ComputerPlayer")) handlePlay2Button();
            }
        } else {
            p1CommandLabel.setVisible(true);
            p1CommandLabel.setText("You can throw dice only when you are an active player. Please wait until other  player makes a move.");
        }


    }

    public void handlePlay2Button() {
        if(activePlayer==player2) {
            if (round == 1) {
                player2.initialThrow();
                generateDices((ArrayList<Integer>) player2.getResult());
                player2.setFigure(DiceEvaluation.evaluate(player2.getResult()));
                result2Label.setText("RESULTS:\tFigure you have: " + player2.getFigure().returnName() + " which gives you points: " + player2.getRank());

                activePlayer = player1;
            }
            round++;
        }
        else {
            p2CommandLabel.setVisible(true);
            p2CommandLabel.setText("You can throw dice only when you are an active player. Please wait until other  player makes a move.");
        }

    }

    private void generateDices(ArrayList<Integer> results) {
        int id = 0;
        for (Integer dice : results) {
            Pane assignedPane = (activePlayer == Main.getPlayers().get(0)) ? p1DicePane : p2DicePane;
            new DiceTile(assignedPane, id, dice);
            id++;
        }
    }


}
