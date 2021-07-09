package com.cshawn.leetcodes.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/7/9 2:59 下午
 */
class Q17_10Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,3}, -1),
                    Arguments.of(new int[]{1,2,3}, -1),
                    Arguments.of(new int[]{-1,-1,2}, -1),
                    Arguments.of(new int[]{-1,-1,2,2}, -1),
                    Arguments.of(new int[]{-1,2,-1,2,2}, 2),
                    Arguments.of(new int[]{1,2,5,9,5,9,5,5,5}, 5),
                    Arguments.of(new int[]{2,2,1,1,1,2,2}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void majorityElement(int[] nums, int result) {
        Assertions.assertEquals(result, new Q17_10().majorityElement(nums));
    }
}