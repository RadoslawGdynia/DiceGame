package Model.DiceLogic.Evaluations;

import Model.DiceLogic.DiceConfigurations.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiceEvaluationTest {

    @Test
    void diceConfigurationEvaluation() {
        //given
        List<Integer> initialList = Arrays.asList(1,1,1,4,5);

        //when
        List<Integer> methodResult = DiceEvaluation.diceConfigurationEvaluation(initialList);
        List<Integer> expectedResult = Arrays.asList(0,1,1,0,0,3);

        //then
        assertEquals(expectedResult, methodResult);
    }

    @Test
    void evaluate_returnYahtzee() {

        //given
        List<Integer> initialDiceResults = Arrays.asList(1,1,1,1,1);

        //when
        Configuration figureCalculated = DiceEvaluation.evaluate(initialDiceResults);

        //then
        assertEquals(Yahtzee.class, figureCalculated.getClass());

    }
    @Test
    void evaluate_returnQuadruple() {

        //given
        List<Integer> initialDiceResults = Arrays.asList(1,1,1,1,4);

        //when
        Configuration figureCalculated = DiceEvaluation.evaluate(initialDiceResults);

        //then
        assertEquals(Quadruple.class, figureCalculated.getClass());

    }
    @Test
    void evaluate_returnFullHouse() {

        //given
        List<Integer> initialDiceResults = Arrays.asList(1,1,1,3,3);

        //when
        Configuration figureCalculated = DiceEvaluation.evaluate(initialDiceResults);

        //then
        assertEquals(FullHouse.class, figureCalculated.getClass());

    }
    @Test
    void evaluate_returnLargeStraight() {

        //given
        List<Integer> initialDiceResults = Arrays.asList(2,3,4,5,6);

        //when
        Configuration figureCalculated = DiceEvaluation.evaluate(initialDiceResults);

        //then
        assertEquals(LargeStraight.class, figureCalculated.getClass());

    }
    @Test
    void evaluate_returnSmallStraight() {

        //given
        List<Integer> initialDiceResults = Arrays.asList(6,4,3,2,1);

        //when
        Configuration figureCalculated = DiceEvaluation.evaluate(initialDiceResults);

        //then
        assertEquals(SmallStraight.class, figureCalculated.getClass());

    }
    @Test
    void evaluate_returnTriple() {

        //given
        List<Integer> initialDiceResults = Arrays.asList(6,6,6,2,4);

        //when
        Configuration figureCalculated = DiceEvaluation.evaluate(initialDiceResults);

        //then
        assertEquals(Triple.class, figureCalculated.getClass());

    }
    @Test
    void evaluate_returnTwoPairs() {

        //given
        List<Integer> initialDiceResults = Arrays.asList(1,1,5,5,2);

        //when
        Configuration figureCalculated = DiceEvaluation.evaluate(initialDiceResults);

        //then
        assertEquals(TwoPairs.class, figureCalculated.getClass());

    }
    @Test
    void evaluate_returnPair() {

        //given
        List<Integer> initialDiceResults = Arrays.asList(1,1,4,3,6);

        //when
        Configuration figureCalculated = DiceEvaluation.evaluate(initialDiceResults);

        //then
        assertEquals(Yahtzee.class, figureCalculated.getClass());

    }
    @Test
    void evaluate_returnNothing() {

        //given
        List<Integer> initialDiceResults = Arrays.asList(2,1,4,5,6);

        //when
        Configuration figureCalculated = DiceEvaluation.evaluate(initialDiceResults);

        //then
        assertEquals(Nothing.class, figureCalculated.getClass());

    }


}