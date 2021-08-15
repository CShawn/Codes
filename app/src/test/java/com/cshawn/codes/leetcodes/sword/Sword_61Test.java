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
 * @date 2021/1/26 3:59 下午
 */
class Sword_61Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,4,5}, true),
                    Arguments.of(new int[]{1,1,2,3,4}, false),
                    Arguments.of(new int[]{3,4,5,0,0}, true),
                    Arguments.of(new int[]{4,5,0,2,1}, true),
                    Arguments.of(new int[]{4,9,0,2,1}, false),
                    Arguments.of(new int[]{0,0,0,0,0}, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isStraight(int[] nums, boolean isStraight) {
        Assertions.assertEquals(isStraight, new Sword_61().isStraight(nums));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isStraight2(int[] nums, boolean isStraight) {
        Assertions.assertEquals(isStraight, new Sword_61().isStraight2(nums));
    }
}