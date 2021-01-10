package Model.DiceLogic.DiceConfigurations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import Model.DiceLogic.EvaluationAlgorithm.DiceEvaluation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

class DiceEvaluationTest {
    DiceEvaluation de = new DiceEvaluation();

    @ParameterizedTest
    @MethodSource("arraylistExamples")
    void evaluate(ArrayList<Integer> tested, String expected) {

    }

    private static Stream<Arguments> arraylistExamples() {
        Integer[] t1 = {1, 5, 6, 1, 1};
        Integer[] t2 = {6, 6, 6, 6, 6};
        Integer[] t3 = {1, 4, 4, 4, 1};
        Integer[] t4 = {1, 2, 3, 4, 5};
        Integer[] t5 = {2, 2, 2, 2, 6};
        Integer[] t6 = {2, 5, 2, 5, 1};

        return Stream.of(
                Arguments.of(Arrays.asList(t1), "[1, 1, 0, 0, 0, 3]"),
                Arguments.of(Arrays.asList(t2), "[5, 0, 0, 0, 0, 0]"),
                Arguments.of(Arrays.asList(t3), "[0, 0, 3, 0, 0, 2]"),
                Arguments.of(Arrays.asList(t4), "[0, 1, 1, 1, 1, 1]"),
                Arguments.of(Arrays.asList(t5), "[1, 0, 0, 0, 4, 0]"),
                Arguments.of(Arrays.asList(t6), "[0, 2, 0, 0, 2, 1]")
        );
    }
}