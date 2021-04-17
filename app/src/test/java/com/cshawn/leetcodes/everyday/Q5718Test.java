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
 * @date 2021/4/17 11:31 下午
 */
class Q5718Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,3},{3,3},{5,3},{2,2}}, new int[][]{{2,3,1},{4,3,1},{1,1,2}}, new int[]{3,2,2}),
                    Arguments.of(new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5}}, new int[][]{{1,2,2},{2,2,2},{4,3,2},{4,3,3}}, new int[]{2,3,2,4})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void countPoints(int[][] points, int[][] queries, int[] result) {
        Assertions.assertArrayEquals(result, new Q5718().countPoints(points, queries));
    }
}