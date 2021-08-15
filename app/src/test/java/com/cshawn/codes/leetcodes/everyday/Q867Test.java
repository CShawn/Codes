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
 * @date 2021/2/25 11:45 上午
 */
class Q867Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0][0], new int[0][0]),
                    Arguments.of(new int[][]{new int[]{1}}, new int[][]{new int[]{1}}),
                    Arguments.of(new int[][]{new int[]{1,2},new int[]{3,4}}, new int[][]{new int[]{1,3}, new int[]{2,4}}),
                    Arguments.of(new int[][]{new int[]{1,2}}, new int[][]{new int[]{1},new int[]{2}}),
                    Arguments.of(new int[][]{new int[]{1},new int[]{2}}, new int[][]{new int[]{1,2}}),
                    Arguments.of(new int[][]{new int[]{1,2,3}, new int[]{4,5,6}}, new int[][]{new int[]{1,4}, new int[]{2,5}, new int[]{3,6}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void transpose(int[][] matrix, int[][] result) {
        Assertions.assertArrayEquals(result, new Q867().transpose(matrix));
    }
}