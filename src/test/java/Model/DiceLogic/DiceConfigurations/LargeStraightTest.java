package Model.DiceLogic.DiceConfigurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargeStraightTest {

    @Test
    void setRank_correctValue_succeed() {
        //given
        int diceValue = 2;

        //when
        Configuration largeStraight = new LargeStraight(diceValue);
        int calculatedRank = largeStraight.setRank();

        //then
        assertEquals(57, calculatedRank);
    }

    @Test
    void setRank_wrongValues_throwsIllegalArgumentException() {
        //given
        int diceValue = -11;

        //then
        assertThrows(IllegalArgumentException.class, () ->new LargeStraight(diceValue));
    }

    @Test
    void checkBorderValue_alwaysBiggerThanSmallStraight_true(){

        //given

        int largeStraightModifier = 1;
        int smallStraightModifier = 6;

        //when
        Configuration smallStraight= new SmallStraight(smallStraightModifier);
        int smallStraightRank = smallStraight.setRank();

        Configuration largeStraight = new LargeStraight(largeStraightModifier);
        int largeStraightRank = largeStraight.setRank();

        //then
        assertTrue(largeStraightRank>smallStraightRank);
    }
}