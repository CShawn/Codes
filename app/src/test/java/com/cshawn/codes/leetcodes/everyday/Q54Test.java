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
 * @date 2021/3/15 11:07 上午
 */
class Q54Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0][0], new Integer[0]),
                    Arguments.of(new int[][]{new int[]{1}}, new Integer[]{1}),
                    Arguments.of(new int[][]{new int[]{1,2}}, new Integer[]{1,2}),
                    Arguments.of(new int[][]{new int[]{1}, new int[]{2}, new int[]{3}}, new Integer[]{1,2,3}),
                    Arguments.of(new int[][]{new int[]{1,2}, new int[]{3,4}}, new Integer[]{1,2,4,3}),
                    Arguments.of(new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}},
                            new Integer[]{1,2,3,6,9,8,7,4,5}),
                    Arguments.of(new int[][]{new int[]{1,2,3,4}, new int[]{5,6,7,8}, new int[]{9,10,11,12}},
                            new Integer[]{1,2,3,4,8,12,11,10,9,5,6,7})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void spiralOrder(int[][] matrix, Integer[] result) {
        Assertions.assertArrayEquals(result, new Q54().spiralOrder(matrix).toArray());
    }
}