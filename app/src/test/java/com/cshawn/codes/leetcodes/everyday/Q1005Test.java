package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/12/3 4:14 下午
 */
class Q1005Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{4,2,3}, 1, 5),
                    Arguments.of(new int[]{3,-1,0,2}, 3, 6),
                    Arguments.of(new int[]{2,-3,-1,5,-4}, 2, 13)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void largestSumAfterKNegations(int[] nums, int k, int result) {
        assertEquals(result, new Q1005().largestSumAfterKNegations1(nums, k));
        assertEquals(result, new Q1005().largestSumAfterKNegations(nums, k));
    }
}