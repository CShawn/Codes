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
 * @date 2021/7/22 3:17 下午
 */
class Q1289Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 13),
                    Arguments.of(new int[][]{{-19,57},{-40,-5}}, -24),
                    Arguments.of(new int[][]{{17,82},{1,-44}}, -27),
                    Arguments.of(new int[][]{{-19}}, -19),
                    Arguments.of(new int[][]{{-37,51,-36,34,-22},{82,4,30,14,38},{-68,-52,-92,65,-85},{-49,-3,-77,8,-19},{-60,-71,-21,-62,-73}}, -268)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minFallingPathSum(int[][] arr, int result) {
        Assertions.assertEquals(result, new Q1289().minFallingPathSum1(arr));
        Assertions.assertEquals(result, new Q1289().minFallingPathSum2(arr));
        Assertions.assertEquals(result, new Q1289().minFallingPathSum3(arr));
        Assertions.assertEquals(result, new Q1289().minFallingPathSum(arr));
    }
}