package Model.DiceLogic.DiceConfigurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripleTest {

    @Test
    void setRank_correctValue_succeed() {
        //given
        int diceValue = 3;

        //when
        Configuration triple = new Triple(diceValue);
        int calculatedRank = triple.setRank();

        //then
        assertEquals(38, calculatedRank);
    }

    @Test
    void setRank_wrongValues_throwsIllegalArgumentException() {
        //given
        int diceValue = 7;

        //then
        assertThrows(IllegalArgumentException.class, () ->new LargeStraight(diceValue));
    }

    @Test
    void checkBorderValue_alwaysBiggerThanTwoPairs_true(){

        //given

        int tripleModifier = 1;
        int twoPairsModifier1 = 6;
        int twoPairsModifier2 = 5;

        //when
        Configuration twoPairs= new TwoPairs(twoPairsModifier1, twoPairsModifier2);
        int twoPairsRank = twoPairs.setRank();

        Configuration triple = new Triple(tripleModifier);
        int tripleRank = triple.setRank();

        //then
        assertTrue(tripleRank>twoPairsRank);
    }

}