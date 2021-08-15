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
 * @date 2021/1/25 12:04 下午
 */
class Sword_57_2Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(15, new int[][]{new int[]{1,2,3,4,5},new int[]{4,5,6},new int[]{7,8}}),
                    Arguments.of(1, new int[0][0]),
                    Arguments.of(6, new int[][]{new int[]{1,2,3}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findContinuousSequence(int target, int[][] result) {
        Assertions.assertArrayEquals(result, new Sword_57_2().findContinuousSequence(target));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findContinuousSequence2(int target, int[][] result) {
        Assertions.assertArrayEquals(result, new Sword_57_2().findContinuousSequence2(target));
    }
}