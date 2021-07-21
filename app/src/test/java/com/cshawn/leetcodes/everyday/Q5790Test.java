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
 * @date 2021/6/20 11:42 上午
 */
class Q5790Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{2,3},{0,3}}, new int[]{2,1,4,1}),
                    Arguments.of(new int[]{4,5,2,2,7,10}, new int[][]{{2,3},{0,2},{0,5},{3,5}}, new int[]{-1,1,1,3})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minDifference(int[] nums, int[][] queries, int[] result) {
        Assertions.assertArrayEquals(result, new Q5790().minDifference1(nums, queries));
        Assertions.assertArrayEquals(result, new Q5790().minDifference2(nums, queries));
        Assertions.assertArrayEquals(result, new Q5790().minDifference(nums, queries));
    }
}