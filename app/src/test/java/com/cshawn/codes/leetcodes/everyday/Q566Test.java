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
 * @date 2021/2/17 10:23 上午
 */
class Q566Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0][0], 1, 0, new int[0][0]),
                    Arguments.of(new int[0][0], 1, 2, new int[0][0]),
                    Arguments.of(new int[][]{new int[]{1}, new int[]{1}}, 1, 1, new int[][]{new int[]{1}, new int[]{1}}),
                    Arguments.of(new int[][]{new int[]{1}, new int[]{1}}, 4, 1, new int[][]{new int[]{1}, new int[]{1}}),
                    Arguments.of(new int[][]{new int[]{1,2}, new int[]{3,4}}, 1, 4, new int[][]{new int[]{1,2,3,4}}),
                    Arguments.of(new int[][]{new int[]{1,2}, new int[]{3,4}}, 4, 1, new int[][]{new int[]{1}, new int[]{2}, new int[]{3}, new int[]{4}}),
                    Arguments.of(new int[][]{new int[]{1,2}, new int[]{3,4}, new int[]{5,6}}, 2, 3, new int[][]{new int[]{1,2,3}, new int[]{4,5,6}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void matrixReshape(int[][] nums, int r, int c, int[][] result) {
        Assertions.assertArrayEquals(result, new Q566().matrixReshape(nums, r, c));
    }
}