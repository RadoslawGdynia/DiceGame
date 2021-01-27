package Controllers;

import Controllers.DiceTile.DiceTile;
import Main.Main;
import Model.DiceGameModel;
import Model.Players.Player;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiceGameController implements GameController {

    public static final Logger log = LoggerFactory.getLogger(DiceGameController.class);
    private final DiceGameModel model = new DiceGameModel(this);

    //In following code "p1" stands for PlayerOne Nodes and "p2" stands for PlayerTwo respectively
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

    private Label activeResultLabel;
    private Label activeCommandLabel;
    private Button activeButton;
    private Pane activePane;
    private final List<CheckBox> p1CheckBoxes = new ArrayList<>();
    private final List<CheckBox> p2CheckBoxes = new ArrayList<>();
    private List<CheckBox> activeCheckBoxes;

    public void initialize() {
        setNameLabels();
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

        if (model.computerIsOpponent()) {
            p2Button.setVisible(false);
            p2CommandLabel.setVisible(false);
        }
        activeButton = p1Button;
        p2Button.setDisable(true);
        activeResultLabel = p1ResultLabel;
        activeCommandLabel = p1CommandLabel;
        activeCheckBoxes = p1CheckBoxes;
        activePane = p1DicePane;
    }

    private void setNameLabels(){
        String[] names = model.providePlayersNames();
        p1Label.setText(names[0]);
        p2Label.setText(names[1]);
    }

    public void handlePlayButton() {
        List<Integer> diceToReRoll = getDiceToReRoll(activeCheckBoxes);
        model.playButtonLogic(diceToReRoll);
    }

    private List<Integer> getDiceToReRoll(List<CheckBox> list) {
        List<Integer> indexesToReRoll = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected()) indexesToReRoll.add(i);
        }
        return indexesToReRoll;
    }
    public void implementRoundChanges(Player activePlayer){
        generateDice(activePlayer.getPlayerDice());
        configureResultLabel(activePlayer);
        changeActiveSection();
    }

    public void generateDice(List<Integer> results) {
        activePane.getChildren().clear();
        for (Integer dice : results) {
            new DiceTile(activePane, dice);
        }
    }
    private void changeActiveSection() {
        changeActivePane();
        changeActiveButton();
        changeActiveCommandLabel();
        changeActiveResultLabel();
        changeActiveCheckBoxes();
    }

    private void changeActivePane(){
        activePane = (activePane == p2DicePane) ? p1DicePane : p2DicePane;
    }

    private void changeActiveButton(){
        activeButton.setDisable(true);
        activeButton = (activeButton == p2Button) ? p1Button : p2Button;
        activeButton.setDisable(false);
    }

    private void changeActiveCommandLabel(){
        activeCommandLabel.setText("Please wait for the opponent to make a move");
        activeCommandLabel = (activeCommandLabel == p2CommandLabel) ? p1CommandLabel : p2CommandLabel;
        activeCommandLabel.setText("Its your turn to play");
    }

    private void changeActiveResultLabel(){
        activeResultLabel = (activeResultLabel == p2ResultLabel) ? p1ResultLabel : p2ResultLabel;
    }

    private void changeActiveCheckBoxes(){
        checkBoxesAreActive(activeCheckBoxes, false);
        activeCheckBoxes = (activeCheckBoxes == p2CheckBoxes) ? p1CheckBoxes : p2CheckBoxes;
        checkBoxesAreActive(activeCheckBoxes, true);
    }

    private void checkBoxesAreActive(List<CheckBox> checkBoxes, boolean state) {
        try {
            for (CheckBox chB : checkBoxes) {
                chB.setDisable(!state);
            }
        } catch (NullPointerException e) {
            log.error("List of checkboxes provided to change of state is null");
        }
    }
    public void configureResultLabel(Player activePlayer) {
        activeResultLabel.setText("RESULTS:\t\tFigure you have: " + activePlayer.getFigure().returnName() + ";\t which gives you points: " + activePlayer.getRank());
    }
    public void showFinalResults(){
        Alert result = new Alert(Alert.AlertType.INFORMATION);
        result.setTitle("WE HAVE A WINNER!");
        result.setHeaderText("This game was won by: " + model.provideWinnerName() + "\n\tit was a great game!");
        result.setContentText("Would you like to try again? \nIf so - please click OK button :)");
        result.getButtonTypes().add(ButtonType.FINISH);
        Optional<ButtonType> playersChoice = result.showAndWait();
        try {
            if (playersChoice.isPresent() && playersChoice.get() == ButtonType.OK){
                Main.restartGame();
                model.clearPlayersScore();
            }
            else Platform.exit();
        }catch (Exception e) {
            log.error("ups...");
        }
    }
}
