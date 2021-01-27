package Model.DiceLogic.DiceConfigurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallStraightTest {

    @Test
    void setRank_correctValue_succeed() {
        //given
        int diceValue = 1;

        //when
        Configuration smallStraight = new SmallStraight(diceValue);
        int calculatedRank = smallStraight.setRank();

        //then
        assertEquals(46, calculatedRank);
    }

    @Test
    void setRank_wrongValues_throwsIllegalArgumentException() {
        //given
        int diceValue = 8;

        //then
        assertThrows(IllegalArgumentException.class, () ->new LargeStraight(diceValue));
    }

    @Test
    void checkBorderValue_alwaysBiggerThanTriple_true(){

        //given

        int tripleModifier = 6;
        int smallStraightModifier = 1;

        //when
        Configuration smallStraight= new SmallStraight(smallStraightModifier);
        int smallStraightRank = smallStraight.setRank();

        Configuration triple = new Triple(tripleModifier);
        int tripleRank = triple.setRank();

        //then
        assertTrue(smallStraightRank>tripleRank);
    }

}