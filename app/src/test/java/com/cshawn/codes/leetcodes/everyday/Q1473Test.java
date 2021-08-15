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
 * @date 2021/5/4 10:52 下午
 */
class Q1473Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,0,0,0,0}, new int[][]{{1,10},{10,1},{1,10},{10,1},{1,10}}, 5, 2, 5, 5),
                    Arguments.of(new int[]{0,0,0,0,0}, new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}}, 5, 2, 3, 9),
                    Arguments.of(new int[]{0,2,1,2,0}, new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}}, 5, 2, 3, 11),
                    Arguments.of(new int[]{3,1,2,3}, new int[][]{{1,1,1},{1,1,1},{1,1,1},{1,1,1}}, 4, 3, 3, -1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minCost(int[] houses, int[][] cost, int m, int n, int target, int result) {
        Assertions.assertEquals(result, new Q1473().minCost(houses, cost, m, n, target));
    }
}