package com.cshawn.leetcodes.crack;

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
 * @date 2021/3/22 10:21 下午
 */
class Q8_2Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[][]{{0,0,0},{0,1,0},{0,0,0}}, new int[][]{{0,0} ,{0,1},{0,2},{1,2},{2,2}}),
                    Arguments.arguments(new int[][]{{0,0,1},{0,1,0},{1,0,0}}, new int[0][0])
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void pathWithObstacles(int[][] n, int[][] result) {
        List<List<Integer>> list = new Q8_2().pathWithObstacles(n);
        if (list.isEmpty()) {
            Assertions.assertArrayEquals(result, new int[0][0]);
        } else {
            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i][0] = list.get(i).get(0);
                res[i][1] = list.get(i).get(1);
            }
            Assertions.assertArrayEquals(result, res);
        }
    }
}