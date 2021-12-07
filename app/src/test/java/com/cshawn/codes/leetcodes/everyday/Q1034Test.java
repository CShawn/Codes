package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author C.Shawn
 * @date 2021/12/7 8:34 上午
 */
class Q1034Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,1},{1,2}}, 0, 0, 3, new int[][]{{3,3},{3,2}}),
                    Arguments.of(new int[][]{{1,2,2},{2,3,2}}, 0, 1, 3, new int[][]{{1,3,3},{2,3,3}}),
                    Arguments.of(new int[][]{{1,1,1},{1,1,1},{1,1,1}}, 1, 1, 2, new int[][]{{2,2,2},{2,1,2},{2,2,2}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void colorBorder(int[][] grid, int row, int col, int color, int[][] result) {
        assertArrayEquals(result, new Q1034().colorBorder(grid, row, col, color));
    }
}