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
 * @date 2021/1/31 12:49 下午
 */
class Sword_51Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 0),
                    Arguments.of(new int[]{1}, 0),
                    Arguments.of(new int[]{1,2}, 0),
                    Arguments.of(new int[]{1,2, 3}, 0),
                    Arguments.of(new int[]{2,2}, 0),
                    Arguments.of(new int[]{3,1,2}, 2),
                    Arguments.of(new int[]{1,3,2}, 1),
                    Arguments.of(new int[]{3,2,1}, 3),
                    Arguments.of(new int[]{4,3,2,1}, 6),
                    Arguments.of(new int[]{4,2,1,3}, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void reversePairs(int[] nums, int count) {
        Assertions.assertEquals(count, new Sword_51().reversePairs(nums));
    }
}