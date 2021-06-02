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
 * @date 2021/6/2 7:59 下午
 */
class Q523Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
//                    Arguments.of(new int[]{23,2,4,6,7}, 6, true),
//                    Arguments.of(new int[]{23,2,6,4,7}, 6, true),
//                    Arguments.of(new int[]{23,2,6,4,7}, 13, false),
                    Arguments.of(new int[]{23,2,4,6,6}, 7, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void checkSubarraySum(int[] nums, int k, boolean result) {
        Assertions.assertEquals(result, new Q523().checkSubarraySum(nums, k));
    }
}