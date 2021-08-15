package com.cshawn.codes.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/4/3 10:22 下午
 */
class Q8_10Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2, new int[][]{{2,2,2} ,{2,2,0},{2,0,1}}),
                    Arguments.arguments(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 2, 2, 3, new int[][]{{1,1,1},{1,1,0},{1,0,3}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void floodFill(int[][] n, int sr, int sc, int newColor, int[][] result) {
        Assertions.assertArrayEquals(result, new Q8_10().floodFill(n, sr, sc, newColor));
    }
}