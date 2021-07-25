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
 * @date 2021/7/25 12:51 下午
 */
class Q1743Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{2,1},{3,4},{3,2}}, new int[]{1,2,3,4}),
                    Arguments.of(new int[][]{{4,-2},{1,4},{-3,1}}, new int[]{-2,4,1,-3}),
                    Arguments.of(new int[][]{{100000,-100000}}, new int[]{100000,-100000})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void restoreArray(int[][] adjacentPairs, int[] result) {
        Assertions.assertArrayEquals(result, new Q1743().restoreArray(adjacentPairs));
    }
}