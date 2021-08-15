package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/6/26 3:14 下午
 */
class Q773Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,2,3},{4,0,5}}, 1),
                    Arguments.of(new int[][]{{1,2,3},{5,4,0}}, -1),
                    Arguments.of(new int[][]{{4,1,2},{5,0,3}}, 5)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void slidingPuzzle(int[][] board, int result) {
        Assertions.assertEquals(result, new Q773().slidingPuzzle1(board));
        Assertions.assertEquals(result, new Q773().slidingPuzzle(board));
    }
}