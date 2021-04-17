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
 * @date 2021/4/17 10:40 上午
 */
class Q220Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,1}, 3, 0, true),
                    Arguments.of(new int[]{1,0,1,1}, 1, 2, true),
                    Arguments.of(new int[]{1,5,9,1,5,9}, 2, 3, false),
                    Arguments.of(new int[]{1,3,5,7}, 5, 1, false),
                    Arguments.of(new int[]{1,3,5,7}, 5, 2, true),
                    Arguments.of(new int[]{1,3,5,7}, 1, 1, false),
                    Arguments.of(new int[]{-2147483648, 2147483647}, 1, 1, false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void containsNearbyAlmostDuplicate(int[] nums, int k, int t, boolean result) {
        Assertions.assertEquals(result, new Q220().containsNearbyAlmostDuplicate1(nums, k, t));
        Assertions.assertEquals(result, new Q220().containsNearbyAlmostDuplicate2(nums, k, t));
        Assertions.assertEquals(result, new Q220().containsNearbyAlmostDuplicate(nums, k, t));
    }
}