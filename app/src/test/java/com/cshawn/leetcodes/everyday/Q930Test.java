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
 * @date 2021/7/8 7:19 下午
 */
class Q930Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0}, 0, 1),
                    Arguments.of(new int[]{0,0,0,0,0}, 0, 15),
                    Arguments.of(new int[]{1,0,1,0,1}, 2, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void numSubarraysWithSum(int[] nums, int goal, int result) {
        Assertions.assertEquals(result, new Q930().numSubarraysWithSum1(nums, goal));
        Assertions.assertEquals(result, new Q930().numSubarraysWithSum2(nums, goal));
        Assertions.assertEquals(result, new Q930().numSubarraysWithSum(nums, goal));
    }
}