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
 * @date 2021/2/24 9:23 上午
 */
class Q832Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0][0], new int[0][0]),
                    Arguments.of(new int[][]{new int[]{1}}, new int[][]{new int[]{0}}),
                    Arguments.of(new int[][]{new int[]{1,0}}, new int[][]{new int[]{1,0}}),
                    Arguments.of(new int[][]{new int[]{1,0,1}}, new int[][]{new int[]{0,1,0}}),
                    Arguments.of(new int[][]{new int[]{1,0,1,0}}, new int[][]{new int[]{1,0,1,0}}),
                    Arguments.of(new int[][]{new int[]{1,1,1,0}}, new int[][]{new int[]{1,0,0,0}}),
                    Arguments.of(new int[][]{new int[]{1,1,1,0},new int[]{0,1,1,0}}, new int[][]{new int[]{1,0,0,0},new int[]{1,0,0,1}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void flipAndInvertImage1(int[][] a, int[][] result) {
        Assertions.assertArrayEquals(result, new Q832().flipAndInvertImage1(a));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void flipAndInvertImage(int[][] a, int[][] result) {
        Assertions.assertArrayEquals(result, new Q832().flipAndInvertImage(a));
    }
}