package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/2/22 9:21 上午
 */
class Q766Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0][0], true),
                    Arguments.of(new int[][]{new int[]{1}, new int[]{2}, new int[]{3}}, true),
                    Arguments.of(new int[][]{new int[]{1, 2, 3}}, true),
                    Arguments.of(new int[][]{new int[]{1, 2}, new int[]{3, 1}}, true),
                    Arguments.of(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, false),
                    Arguments.of(new int[][]{new int[]{1,2,3,4}, new int[]{5,1,2,3}, new int[]{9,5,1,2}}, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isToeplitzMatrix(int[][] matrix, boolean result) {
        Assertions.assertEquals(result, new Q766().isToeplitzMatrix(matrix));
    }
}