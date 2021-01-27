package Model.DiceLogic.Evaluations;

import Model.DiceLogic.DiceConfigurations.Configuration;
import Model.DiceLogic.DiceConfigurations.Nothing;
import Model.DiceLogic.DiceConfigurations.Quadruple;
import Model.Players.HumanPlayer;
import Model.Players.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultsTest {
        Player player1 = new HumanPlayer("First");
        Player player2 = new HumanPlayer("Second");



    @Test
    void finalResult_player1Won() {
        //given
        Configuration player1Configuration = new Quadruple(6);
        player1.setFigure(player1Configuration);

        Configuration player2Configuration = new Nothing();
        player2.setFigure(player2Configuration);

        //when

        String winnerName = Results.finalResult(player1, player2);

        //then
        assertEquals("First", winnerName);

    }

    @Test
    void finalResult_player2Won() {
        //given
        Configuration player1Configuration = new Quadruple(1);
        player1.setFigure(player1Configuration);

        Configuration player2Configuration = new Quadruple(6);
        player2.setFigure(player2Configuration);

        //when

        String winnerName = Results.finalResult(player1, player2);

        //then
        assertEquals("Second", winnerName);

    }

    @Test
    void finalResult_draw() {
        //given
        Configuration configuration = new Quadruple(6);
        player1.setFigure(configuration);
        player2.setFigure(configuration);

        //when

        String winnerName = Results.finalResult(player1, player2);

        //then
        assertEquals("both of you. However unlikely it was a draw!", winnerName);

    }
}