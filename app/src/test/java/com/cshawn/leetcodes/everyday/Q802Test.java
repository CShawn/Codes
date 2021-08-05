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
 * @date 2021/8/5 11:06 上午
 */
class Q802Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{0}}, new Integer[0]),
                    Arguments.of(new int[][]{{1},{0}}, new Integer[0]),
                    Arguments.of(new int[][]{{1},{0},{}}, new Integer[]{2}),
                    Arguments.of(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}, new Integer[]{2,4,5,6}),
                    Arguments.of(new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}}, new Integer[]{4})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void eventualSafeNodes(int[][] graph, Integer[] result) {
        Assertions.assertArrayEquals(result, new Q802().eventualSafeNodes1(graph).toArray());
        Assertions.assertArrayEquals(result, new Q802().eventualSafeNodes2(graph).toArray());
        Assertions.assertArrayEquals(result, new Q802().eventualSafeNodes(graph).toArray());
    }
}