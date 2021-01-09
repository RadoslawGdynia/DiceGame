package pl.RadoslawGdynia.DiceGame.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.RadoslawGdynia.DiceGame.Controllers.DiceGameLayoutController;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    public static final Logger log = LoggerFactory.getLogger(DiceGameLayoutController.class);
    static Stage mainStage;

    @Override
    public void start(Stage stage) {
       try{
           initialiseGame();
           mainStage = stage;
           startGame();

       } catch (Exception e) {
           log.error("Problems occurred during program initialisation");
        }

    }
    public static void main(String[] args) {
        launch(args);
    }

    public static void initialiseGame() throws Exception{
        Stage stage1 = new Stage();
        URL url1 = new File("src/main/resources/StartGame.fxml").toURI().toURL();
        Parent root1 = FXMLLoader.load(url1);
        stage1.setScene(new Scene(root1, 600, 400));
        stage1.showAndWait();
    }
    public static void startGame() throws Exception{
        URL url = new File("src/main/resources/DiceGameLayout.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        mainStage.setTitle("Dice game");
        mainStage.setScene(new Scene(root, 1000, 700));
        mainStage.show();
    }
    public static void restartGame() throws Exception{
        mainStage.close();
        startGame();
    }
}
