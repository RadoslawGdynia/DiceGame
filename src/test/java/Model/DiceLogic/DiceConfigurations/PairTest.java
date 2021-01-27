package Model.DiceLogic.DiceConfigurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void setRank_correctValue_succeed() {
        //given
        int diceValue = 6;

        //when
        Configuration pair = new Pair(diceValue);
        int calculatedRank = pair.setRank();

        //then
        assertEquals(16, calculatedRank);
    }

    @Test
    void setRank_wrongValues_throwsIllegalArgumentException() {
        //given
        int diceValue = -1;

        //then
        assertThrows(IllegalArgumentException.class, () ->new Pair(diceValue));
    }

    @Test
    void checkBorderValue_alwaysBiggerThanNothing_true(){

        //given

        int pairModifier = 1;

        //when
        Configuration nothing = new Nothing();
        int nothingRank = nothing.setRank();

        Configuration pair = new Pair(pairModifier);
        int pairRank = pair.setRank();

        //then
        assertTrue(pairRank>nothingRank);
    }
}