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
 * @date 2021/3/16 9:14 上午
 */
class Q59Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(0, new int[0][0]),
                    Arguments.of(1, new int[][]{new int[]{1}}),
                    Arguments.of(2, new int[][]{new int[]{1,2}, new int[]{4,3}}),
                    Arguments.of(3, new int[][]{new int[]{1,2,3}, new int[]{8,9,4}, new int[]{7,6,5}}),
                    Arguments.of(4, new int[][]{new int[]{1,2,3,4}, new int[]{12,13,14,5}, new int[]{11,16,15,6}, new int[]{10,9,8,7}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void generateMatrix(int n, int[][] result) {
        Assertions.assertArrayEquals(result, new Q59().generateMatrix(n));
    }
}