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
 * @date 2021/8/6 5:23 下午
 */
class Q847Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0][], 0),
                    Arguments.of(new int[][]{{0}}, 0),
                    Arguments.of(new int[][]{{1},{0}}, 1),
                    Arguments.of(new int[][]{{1},{0,2},{}}, 2),
                    Arguments.of(new int[][]{{1,2,3},{0},{0},{0}}, 4),
                    Arguments.of(new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}}, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void shortestPathLength(int[][] graph, int result) {
        Assertions.assertEquals(result, new Q847().shortestPathLength1(graph));
        Assertions.assertEquals(result, new Q847().shortestPathLength(graph));
    }
}