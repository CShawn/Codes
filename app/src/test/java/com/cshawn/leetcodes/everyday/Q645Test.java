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
 * @date 2021/7/4 10:05 上午
 */
class Q645Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1, 2, 2, 4}, 2, 3),
                    Arguments.of(new int[]{1, 1, 3, 4}, 1, 2),
                    Arguments.of(new int[]{1, 2, 4, 4}, 4, 3),
                    Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 10}, 10, 9),
                    Arguments.of(new int[]{1, 1}, 1, 2),
                    Arguments.of(new int[]{8,7,3,5,3,6,1,4}, 3, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findErrorNums(int[] nums, int repeat, int lost) {
        Assertions.assertArrayEquals(new int[]{repeat, lost}, new Q645().findErrorNums1(nums));
        Assertions.assertArrayEquals(new int[]{repeat, lost}, new Q645().findErrorNums(nums));
    }
}