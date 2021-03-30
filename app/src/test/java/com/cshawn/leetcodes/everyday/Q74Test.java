package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/3/30 3:21 下午
 */
class Q74Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3, true),
                    Arguments.arguments(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 16, true),
                    Arguments.arguments(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 0, false),
                    Arguments.arguments(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13, false),
                    Arguments.arguments(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 70, false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void searchMatrix(int[][] matrix, int target, boolean result) {
        Assertions.assertEquals(result, new Q74().searchMatrix1(matrix, target));
        Assertions.assertEquals(result, new Q74().searchMatrix(matrix, target));
    }
}