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
 * @date 2021/7/22 11:10 上午
 */
class Q64Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[][]{{1,3,1},{1,5,1},{4,2,1}}, 7),
                    Arguments.arguments(new int[][]{{1,2,3},{4,5,6}}, 12),
                    Arguments.arguments(new int[][]{{1,2},{1,1}}, 3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minPathSum(int[][] grid, int result) {
        Assertions.assertEquals(result, new Q64().minPathSum(grid));
    }
}