package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @Date 2020/12/13 22:53
 */
class Sword_29Test {
    private final Sword_29 test = new Sword_29();

    static class SpiralArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{}, new int[]{}),
                    Arguments.of(new int[][]{{1}}, new int[]{1}),
                    Arguments.of(new int[][]{{1, 2, 3}}, new int[]{1, 2, 3}),
                    Arguments.of(new int[][]{{1, 2}, {3, 4}}, new int[]{1, 2, 4, 3}),
                    Arguments.of(new int[][]{{1, 2}, {3, 4}, {5, 6}}, new int[]{1,2,4,6,5,3}),
                    Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{1,2,3,6,9,8,7,4,5})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(SpiralArgumentsProvider.class)
    void spiralOrder(int[][] matrix, int[] spiralOrder) {
        assertArrayEquals(spiralOrder, test.spiralOrder(matrix));
    }
}