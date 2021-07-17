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
 * @date 2021/7/17 12:02 下午
 */
class Q53Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6),
                    Arguments.of(new int[]{1}, 1),
                    Arguments.of(new int[]{0}, 0),
                    Arguments.of(new int[]{1}, 1),
                    Arguments.of(new int[]{-1}, -1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxSubArray(int[] nums, int result) {
        Assertions.assertEquals(result, new Q53().maxSubArray1(nums));
        Assertions.assertEquals(result, new Q53().maxSubArray(nums));
    }
}