package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/2/24 5:14 下午
 */
class Q1_7Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0][0], new int[0][0]),
                    Arguments.of(new int[][]{new int[]{1}}, new int[][]{new int[]{1}}),
                    Arguments.of(new int[][]{new int[]{1,2}, new int[]{3,4}}, new int[][]{new int[]{3,1}, new int[]{4,2}}),
                    Arguments.of(new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}},
                            new int[][]{new int[]{7,4,1}, new int[]{8,5,2}, new int[]{9,6,3}}),
                    Arguments.of(new int[][]{new int[]{1,2,3,4}, new int[]{5,6,7,8}, new int[]{9,10,11,12}, new int[]{13,14,15,16}},
                            new int[][]{new int[]{13,9,5,1}, new int[]{14,10,6,2}, new int[]{15,11,7,3}, new int[]{16,12,8,4}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void rotate1(int[][] matrix, int[][] result) {
        Assertions.assertArrayEquals(result, new Q1_7().rotate1(matrix));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void rotate(int[][] matrix, int[][] result) {
        Assertions.assertArrayEquals(result, new Q1_7().rotate(matrix));
    }
}