package ex.easy.problems.twosum;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Should check that TwoSum solution is correct")
class TwoSumSolutionTest {

    private TwoSumSolution twoSumSolution;

    @BeforeEach
    void setUp() {
        twoSumSolution = new TwoSumSolution();
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void shouldCheckBruteForceSolution(int[] nums, int target, int[] expectedNums) {
        int[] result = twoSumSolution.bruteForce(nums, target);
        Assertions.assertThat(result).isEqualTo(expectedNums);
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void shouldCheckOnePassHashTableSolution(int[] nums, int target, int[] expectedNums) {
        int[] result = twoSumSolution.onePassHashTable(nums, target);
        Assertions.assertThat(result).isEqualTo(expectedNums);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }
}
