module DiceGame {
    requires javafx.controls;
    requires javafx.fxml;
    requires slf4j.api;

    opens pl.RadoslawGdynia.DiceGame.Main;
    opens pl.RadoslawGdynia.DiceGame.Controllers;
}