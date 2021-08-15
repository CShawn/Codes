package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/1/17 9:46 下午
 */
class Sword_47Test {
    static class TestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0][0], 0),
                    Arguments.of(new int[][]{new int[]{1,3,1},new int[]{1,5,1},new int[]{4,2,1}}, 12),
                    Arguments.of(new int[][]{new int[]{1,3,6},new int[]{2,5,1},new int[]{0,2,3}}, 14),
                    Arguments.of(new int[][]{new int[]{1,2,5},new int[]{3,2,1}}, 9)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void maxValue(int[][] grid, int value) {
        Assertions.assertEquals(value, new Sword_47().maxValue(grid));
    }
}