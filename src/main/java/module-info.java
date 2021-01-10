module DiceGame {
    requires javafx.controls;
    requires javafx.fxml;
    requires slf4j.api;

    opens Main;
    opens Controllers;
}