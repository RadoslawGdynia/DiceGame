package pl.RadoslawGdynia.DiceGame.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.RadoslawGdynia.DiceGame.DiceTile.DiceTile;
import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceConfigurations.DiceEvaluation;
import pl.RadoslawGdynia.DiceGame.Main.Main;
import pl.RadoslawGdynia.DiceGame.Player.ComputerPlayer;
import pl.RadoslawGdynia.DiceGame.Player.HumanPlayer;
import pl.RadoslawGdynia.DiceGame.Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private Label p1Label;
    @FXML
    private Label p2Label;
    @FXML
    private Button p1Button;
    @FXML
    private Button p2Button;
    @FXML
    private Label p1ResultLabel;
    @FXML
    private Label p2ResultLabel;
    @FXML
    CheckBox p1CheckBox1;
    @FXML
    CheckBox p1CheckBox2;
    @FXML
    CheckBox p1CheckBox3;
    @FXML
    CheckBox p1CheckBox4;
    @FXML
    CheckBox p1CheckBox5;
    @FXML
    CheckBox p2CheckBox1;
    @FXML
    CheckBox p2CheckBox2;
    @FXML
    CheckBox p2CheckBox3;
    @FXML
    CheckBox p2CheckBox4;
    @FXML
    CheckBox p2CheckBox5;


    private int round = 0;
    private Player activePlayer;
    private Label activeResultLabel;
    private Label activeCommandLabel;
    private Button activeButton;
    private Pane activePane;
    private final List<CheckBox> p1CheckBoxes = new ArrayList<>();
    private final List<CheckBox> p2CheckBoxes = new ArrayList<>();
    private List<CheckBox> activeCheckBoxes;

    private final Player player1 = Main.getPlayers().get(0);
    private final Player player2 = Main.getPlayers().get(1);

    public void initialize() {
        p1Label.setText(player1.getPLAYER_NAME());
        p2Label.setText(player2.getPLAYER_NAME());
        p1CheckBoxes.add(p1CheckBox1);
        p1CheckBoxes.add(p1CheckBox2);
        p1CheckBoxes.add(p1CheckBox3);
        p1CheckBoxes.add(p1CheckBox4);
        p1CheckBoxes.add(p1CheckBox5);
        p2CheckBoxes.add(p2CheckBox1);
        p2CheckBoxes.add(p2CheckBox2);
        p2CheckBoxes.add(p2CheckBox3);
        p2CheckBoxes.add(p2CheckBox4);
        p2CheckBoxes.add(p2CheckBox5);

        if (player2 instanceof ComputerPlayer) {
            p2CommandLabel.setVisible(false);
            p2Button.setVisible(false);
        }
        activeButton = p1Button;
        p2Button.setDisable(true);
        activePlayer = player1;
        activeResultLabel = p1ResultLabel;
        activeCommandLabel = p1CommandLabel;
        activeCheckBoxes = p1CheckBoxes;
        activePane = p1DicePane;
    }

    public void handlePlayButton() {
        round++;
        if (round <3) {
            activePlayer.initialThrow();
            generateDices(activePlayer.getResult());
            configureResultLabel();
            changeActivePlayer();
            if (player2 instanceof ComputerPlayer) {
                handlePlayButton();

            }
        } else {
            List<Integer> list = getDicesToReRoll(activeCheckBoxes);
            if (activePlayer instanceof HumanPlayer) {
                if (list.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("You decided not to re-roll any dices.");
                    alert.setContentText("If you want to proceed press OK, if you would like to select dices to re-roll press CANCEL");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() != ButtonType.OK) {
                        ((HumanPlayer) activePlayer).decision(list);
                        changeActivePlayer();
                    } else {
                        return;
                    }
                } else {
                    ((HumanPlayer) activePlayer).decision(list);
                    generateDices(activePlayer.getResult());
                    configureResultLabel();
                    changeActivePlayer();
                }

            }
        }
    }

    private void generateDices(List<Integer> results) {
        activePane.getChildren().clear();
        for (Integer dice : results) {
            new DiceTile(activePane, dice);
        }
    }

    private void changeActivePlayer() {
        activePlayer = (activePlayer == player1) ? player2 : player1;
        changeActiveSection();
    }

    private void changeActiveSection() {
        activeButton.setDisable(true);
        activePane = (activePlayer == player1) ? p1DicePane : p2DicePane;
        activeCommandLabel.setText("Please wait for the opponent to make a move");
        activeButton = (activePlayer == player1) ? p1Button : p2Button;
        activeButton.setDisable(false);
        activeResultLabel = (activePlayer == player1) ? p1ResultLabel : p2ResultLabel;
        activeCommandLabel = (activePlayer == player1) ? p1CommandLabel : p2CommandLabel;
        activeCommandLabel.setText("Its your turn to play");
        checkBoxesAreActive(activeCheckBoxes, false);
        activeCheckBoxes = (activePlayer == player1) ? p1CheckBoxes : p2CheckBoxes;
        checkBoxesAreActive(activeCheckBoxes, true);
    }

    private void checkBoxesAreActive(List<CheckBox> list, boolean state) {
        try {
            for (CheckBox chB : list) {
                chB.setDisable(!state);
            }
        } catch (NullPointerException e) {
            log.error("List of checkboxes provided to change their state is null");
        }
    }

    private List<Integer> getDicesToReRoll(List<CheckBox> list) {
        List<Integer> indexesToReRoll = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected()) indexesToReRoll.add(i);
        }
        return indexesToReRoll;
    }
    private void configureResultLabel(){
        activePlayer.setFigure(DiceEvaluation.evaluate(activePlayer.getResult()));
        activeResultLabel.setText("RESULTS:\t\tFigure you have: " + activePlayer.getFigure().returnName() + ";\t which gives you points: " + activePlayer.getRank());
    }


}
