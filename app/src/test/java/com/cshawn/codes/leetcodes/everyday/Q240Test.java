package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/10/25 3:27 下午
 */
class Q240Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1}}, 1, true),
                    Arguments.of(new int[][]{{1}}, 0, false),
                    Arguments.of(new int[][]{{1}}, 2, false),
                    Arguments.of(new int[][]{{1,3},{2,4}}, 2, true),
                    Arguments.of(new int[][]{{1,3},{2,4}}, 1, true),
                    Arguments.of(new int[][]{{1,3},{2,4}}, 4, true),
                    Arguments.of(new int[][]{{1,3},{2,4}}, 0, false),
                    Arguments.of(new int[][]{{1,3},{2,4}}, 5, false),
                    Arguments.of(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5, true),
                    Arguments.of(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 9, true),
                    Arguments.of(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20, false),
                    Arguments.of(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 0, false),
                    Arguments.of(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 31, false),
                    Arguments.of(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}, 19, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void searchMatrix(int[][] matrix, int target, boolean result) {
        assertEquals(result, new Q240().searchMatrix1(matrix, target));
        assertEquals(result, new Q240().searchMatrix(matrix, target));
    }
}