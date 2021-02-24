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
 * @date 2021/2/24 8:00 下午
 */
class Q1_8Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0][0], new int[0][0]),
                    Arguments.of(new int[][]{new int[]{1}}, new int[][]{new int[]{1}}),
                    Arguments.of(new int[][]{new int[]{1,0}, new int[]{3,4}}, new int[][]{new int[]{0,0}, new int[]{3,0}}),
                    Arguments.of(new int[][]{new int[]{1,1,1}, new int[]{1,0,1}, new int[]{1,1,1}},
                            new int[][]{new int[]{1,0,1}, new int[]{0,0,0}, new int[]{1,0,1}}),
                    Arguments.of(new int[][]{new int[]{1,0,0,4}, new int[]{5,6,0,8}, new int[]{9,10,11,12}, new int[]{13,14,15,16}},
                            new int[][]{new int[]{0,0,0,0}, new int[]{0,0,0,0}, new int[]{9,0,0,12}, new int[]{13,0,0,16}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void setZeroes1(int[][] matrix, int[][] result) {
        Assertions.assertArrayEquals(result, new Q1_8().setZeroes1(matrix));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void setZeroes(int[][] matrix, int[][] result) {
        Assertions.assertArrayEquals(result, new Q1_8().setZeroes(matrix));
    }
}