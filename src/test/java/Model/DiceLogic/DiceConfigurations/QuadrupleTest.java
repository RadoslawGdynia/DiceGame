package Model.DiceLogic.DiceConfigurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadrupleTest {

    @Test
    void setRank_correctValue_succeed() {
        //given
        int diceValue = 4;

        //when
        Configuration quadruple = new Quadruple(diceValue);
        int calculatedRank = quadruple.setRank();

        //then
        assertEquals(106, calculatedRank);
    }

    @Test
    void setRank_wrongValues_throwsIllegalArgumentException() {
        //given
        int diceValue = 9999;

        //then
        assertThrows(IllegalArgumentException.class, () ->new LargeStraight(diceValue));
    }

    @Test
    void checkBorderValue_alwaysBiggerThanFullHouse_true(){

        //given

        int fullHouseModifier1 = 6;
        int fullHouseModifier2 = 5;
        int quadrupleModifier = 1;

        //when
        Configuration fullHouse= new FullHouse(fullHouseModifier1, fullHouseModifier2);
        int fullHouseRank = fullHouse.setRank();

        Configuration quadruple = new Quadruple(quadrupleModifier);
        int quadrupleRank = quadruple.setRank();

        //then
        assertTrue(quadrupleRank>fullHouseRank);

    }

}