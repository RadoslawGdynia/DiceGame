package pl.RadoslawGdynia.DiceGame.Main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.RadoslawGdynia.DiceGame.Controllers.DiceGameLayoutController;
import pl.RadoslawGdynia.DiceGame.EvaluationAlgorithms.DiceEvaluation;
import pl.RadoslawGdynia.DiceGame.Player.Player;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class Main extends Application {
    private static List<Player> players;
    public static final Logger log = LoggerFactory.getLogger(DiceGameLayoutController.class);
    static Stage mainStage;

    @Override
    public void start(Stage stage) {
       try{
           initialiseGame();
           mainStage = stage;
           startGame(stage);
       } catch (Exception e) {
           log.error("Problems occurred during program initialisation");
        }

    }
    public static void main(String[] args) {
        launch(args);
    }

    public static void setPlayers(List<Player> player) {
        players = player;
    }

    public static List<Player> getPlayers() {
        return players;
    }
    public static void finalResults(){
        Alert result = new Alert(Alert.AlertType.INFORMATION);
        result.setTitle("WE HAVE A WINNER!");
        result.setHeaderText("This game was won by: " + DiceEvaluation.finalResult() + "\n\t it was a great game!");
        result.setContentText("Would you like to try again? \n If so - please click OK button :)");
        result.getButtonTypes().add(ButtonType.FINISH);
        Optional<ButtonType> click = result.showAndWait();
        try {
            if (click.isPresent() && click.get() == ButtonType.OK){
                restartGame(mainStage);
//                startGame(new Stage());
//                for(Player p : players){
//                    p.getResult().clear();
//                }
            }
            else Platform.exit();
        }catch (Exception e) {
            log.error("ups...");
        }

    }
    public static void initialiseGame() throws Exception{
        Stage stage1 = new Stage();
        URL url1 = new File("src/main/resources/StartGame.fxml").toURI().toURL();
        Parent root1 = FXMLLoader.load(url1);
        stage1.setScene(new Scene(root1, 600, 400));
        stage1.showAndWait();
    }
    public static void startGame(Stage stage) throws Exception{
        URL url = new File("src/main/resources/DiceGameLayout.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setTitle("Dice game");
        stage.setScene(new Scene(root, 1000, 700));
        stage.show();
    }
    public static void restartGame(Stage stage) throws Exception{
        stage.close();
        for(Player p : players){
            p.getResult().clear();
        }
        startGame(stage);
    }
}
