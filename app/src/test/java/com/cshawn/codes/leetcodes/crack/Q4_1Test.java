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
 * @date 2021/3/1 9:51 下午
 */
class Q4_1Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(3, new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}, new int[]{1, 2}}, 0, 2, true),
                    Arguments.of(4, new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}, new int[]{1, 3}}, 0, 3, true),
                    Arguments.of(4, new int[][]{new int[]{0, 1}, new int[]{3, 2}, new int[]{1, 0}, new int[]{2, 3}, new int[]{0, 2}}, 0, 3, true),
                    Arguments.of(4, new int[][]{new int[]{0, 2}, new int[]{1, 2}, new int[]{1, 3}}, 0, 3, false),
                    Arguments.of(5, new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 4}, new int[]{0, 4},
                            new int[]{0, 1},new int[]{1, 3},new int[]{1, 4},new int[]{1, 3},new int[]{2, 3},new int[]{3, 4}}, 0, 4, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findWhetherExistsPath(int n, int[][] graph, int start, int target, boolean result) {
        Assertions.assertEquals(result, new Q4_1().findWhetherExistsPath(n, graph, start, target));
    }
}