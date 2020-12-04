package pl.RadoslawGdynia.DiceGame.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import pl.RadoslawGdynia.DiceGame.DiceTile.DiceTile;
import pl.RadoslawGdynia.DiceGame.Main.Main;

import java.util.ArrayList;

public class DiceGameLayoutController {
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

    private int round = 1;

    public void initialize() {
        player1Label.setText(Main.getPlayers().get(0).getPLAYER_NAME());
        player2Label.setText(Main.getPlayers().get(1).getPLAYER_NAME());
        if(player2Label.getText().equals("COMPUTER")){
            p2CommandLabel.setVisible(false);
            play2Button.setDisable(true);
            play2Button.setVisible(false);

        }
    }
    public void handlePlay1Button(){
        if(round==1){
            Main.getPlayers().get(0).initialThrow();
            generateDices((ArrayList<Integer>)Main.getPlayers().get(0).getResult());
        }
        round++;

    }
    public void handlePlay2Button(){

    }
    private void generateDices(ArrayList<Integer> results){
        int id = 0;
        for(Integer dice : results){
            new DiceTile(p1DicePane, id, dice);
            id++;
        }
    }


}
