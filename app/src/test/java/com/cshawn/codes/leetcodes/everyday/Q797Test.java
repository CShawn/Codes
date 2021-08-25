package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/8/25 10:50 上午
 */
class Q797Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,2},{3},{3},{}}, new Integer[][]{{0,1,3},{0,2,3}}),
                    Arguments.of(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}, new Integer[][]{{0,4},{0,3,4},{0,1,3,4},{0,1,2,3,4},{0,1,4}}),
                    Arguments.of(new int[][]{{1},{}}, new Integer[][]{{0,1}}),
                    Arguments.of(new int[][]{{1,2,3},{2},{3},{}}, new Integer[][]{{0,1,2,3},{0,2,3},{0,3}}),
                    Arguments.of(new int[][]{{1,3},{2},{3},{}}, new Integer[][]{{0,1,2,3},{0,3}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void allPathsSourceTarget(int[][] graph, Integer[][] result) {
        List<List<Integer>> res = new Q797().allPathsSourceTarget(graph);
        Integer[][] arr = new Integer[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, arr);
    }
}