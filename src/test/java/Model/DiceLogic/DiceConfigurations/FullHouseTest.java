package Model.DiceLogic.DiceConfigurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullHouseTest {

    @Test
    void setRank_correctValues_succeed() {
        //given
        int diceValue1 = 2;
        int diceValue2 = 6;

        //when
        Configuration fullHouse = new FullHouse(diceValue1, diceValue2);
        int calculatedRank = fullHouse.setRank();

        //then
        assertEquals(78, calculatedRank);
    }

    @Test
    void setRank_wrongValues_throwsIllegalArgumentException() {
        //given
        int diceValue1 = -2;
        int diceValue2 = 8;

        //then
        assertThrows(IllegalArgumentException.class, () ->new FullHouse(diceValue1, diceValue2));
    }

    @Test
    void checkBorderValue_alwaysBiggerThanLargeStraight_true(){

        //given

        int fullHouseModifier1 = 1;
        int fullHouseModifier2 = 2;

        int largeStraightModifier = 6;

        //when
        Configuration fullHouse= new FullHouse(fullHouseModifier1, fullHouseModifier2);
        int fullHouseRank = fullHouse.setRank();

        Configuration largeStraight = new LargeStraight(largeStraightModifier);
        int largeStraightRank = largeStraight.setRank();

        //then
        assertTrue(fullHouseRank>largeStraightRank);

    }
}