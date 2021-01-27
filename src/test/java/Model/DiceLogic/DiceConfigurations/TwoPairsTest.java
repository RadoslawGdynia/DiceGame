package Model.DiceLogic.DiceConfigurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoPairsTest {

    @Test
    void setRank_correctValue_succeed() {
        //given
        int diceValue1 = 2;
        int diceValue2 = 4;

        //when
        Configuration twoPairs = new TwoPairs(diceValue1, diceValue2);
        int calculatedRank = twoPairs.setRank();

        //then
        assertEquals(26, calculatedRank);
    }

    @Test
    void setRank_wrongValues_throwsIllegalArgumentException() {
        //given
        int diceValue1 = -11;
        int diceValue2 = 2;

        //then
        assertThrows(IllegalArgumentException.class, () ->new TwoPairs(diceValue1, diceValue2));
    }

    @Test
    void checkBorderValue_alwaysBiggerThanPair_true(){

        //given

        int pairModifier = 6;
        int twoPairsModifier1 = 1;
        int twoPairsModifier2 = 2;

        //when
        Configuration twoPairs= new TwoPairs(twoPairsModifier1, twoPairsModifier2);
        int twoPairsRank = twoPairs.setRank();

        Configuration pair = new Pair(pairModifier);
        int pairRank = pair.setRank();

        //then
        assertTrue(twoPairsRank>pairRank);
    }
}