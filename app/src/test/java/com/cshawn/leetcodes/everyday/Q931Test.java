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
 * @date 2021/7/22 2:08 下午
 */
class Q931Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{2,1,3},{6,5,4},{7,8,9}}, 13),
                    Arguments.of(new int[][]{{-19,57},{-40,-5}}, -59),
                    Arguments.of(new int[][]{{17,82},{1,-44}}, -27),
                    Arguments.of(new int[][]{{-19}}, -19)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minFallingPathSum(int[][] matrix, int result) {
        Assertions.assertEquals(result, new Q931().minFallingPathSum1(matrix));
        Assertions.assertEquals(result, new Q931().minFallingPathSum(matrix));
    }
}