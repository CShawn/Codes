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
 * @date 2021/4/23 11:07 下午
 */
class Q368Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3}, new Integer[]{3}),
                    Arguments.of(new int[]{2,7}, new Integer[]{2}),
                    Arguments.of(new int[]{2,4}, new Integer[]{4,2}),
                    Arguments.of(new int[]{1,2,3}, new Integer[]{2,1}),
                    Arguments.of(new int[]{1,2,4,8}, new Integer[]{8,4,2,1}),
                    Arguments.of(new int[]{2,3,4,9,8}, new Integer[]{8,4,2})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void largestDivisibleSubset(int[] nums, Integer[] result) {
        Assertions.assertArrayEquals(result, new Q368().largestDivisibleSubset(nums).toArray());
    }
}