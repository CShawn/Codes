package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/9/16 6:31 下午
 */
class Q980Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}, 2),
                    Arguments.of(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}, 4),
                    Arguments.of(new int[][]{{0,1},{2,0}}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void uniquePathsIII(int[][] grid, int result) {
        assertEquals(result, new Q980().uniquePathsIII(grid));
    }
}