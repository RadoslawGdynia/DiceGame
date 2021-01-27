package Model.DiceLogic.DiceConfigurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YahtzeeTest {

    @Test
    void setRank_correctValue_succeed() {
        //given
        int diceValue = 5;

        //when
        Configuration yahtzee = new Yahtzee(diceValue);
        int calculatedRank = yahtzee.setRank();

        //then
        assertEquals(145, calculatedRank);
    }

    @Test
    void setRank_wrongValues_throwsIllegalArgumentException() {
        //given
        int diceValue = 0;

        //then
        assertThrows(IllegalArgumentException.class, () ->new LargeStraight(diceValue));
    }

    @Test
    void checkBorderValue_alwaysBiggerThanQuadruple_true(){

        //given
        int yahtzeeModifier = 1;
        int quadrupleModifier = 6;

        //when
        Configuration yahtzee = new Yahtzee(yahtzeeModifier);
        int yahtzeeRank = yahtzee.setRank();

        Configuration quadruple = new Quadruple(quadrupleModifier);
        int quadrupleRank = quadruple.setRank();

        //then
        assertTrue(yahtzeeRank>quadrupleRank);


    }

}