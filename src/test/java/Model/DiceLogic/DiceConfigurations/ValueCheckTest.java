package Model.DiceLogic.DiceConfigurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueCheckTest {

    @Test
    void isInCorrectRange_oneValue_True() {
        //testing border values
        assertTrue(ValueCheck.isInCorrectRange(1));
        assertTrue(ValueCheck.isInCorrectRange(6));
    }
    @Test
    void isInCorrectRange_oneValue_False() {
        //testing border values
        assertFalse(ValueCheck.isInCorrectRange(0));
        assertFalse(ValueCheck.isInCorrectRange(7));
    }

    @Test
    void isInCorrectRange_twoValues_BothCorrect() {
        //testing border values
        assertTrue(ValueCheck.isInCorrectRange(1, 6));
        assertTrue(ValueCheck.isInCorrectRange(6, 6));
        assertTrue(ValueCheck.isInCorrectRange(1, 1));
    }
    @Test
    void isInCorrectRange_twoValues_OneCorrect() {
        //testing border values
        assertFalse(ValueCheck.isInCorrectRange(0, 3));
        assertFalse(ValueCheck.isInCorrectRange(7, 5));
    }

    @Test
    void isInCorrectRange_twoValues_BothWrong() {
        //testing border values
        assertFalse(ValueCheck.isInCorrectRange(0, 0));
        assertFalse(ValueCheck.isInCorrectRange(7, 7));
        assertFalse(ValueCheck.isInCorrectRange(0, 7));
    }
}