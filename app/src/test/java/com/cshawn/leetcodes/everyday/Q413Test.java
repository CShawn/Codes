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
 * @date 2021/8/10 9:24 上午
 */
class Q413Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,4}, 3),
                    Arguments.of(new int[]{1,2,3}, 1),
                    Arguments.of(new int[]{1}, 0),
                    Arguments.of(new int[]{2,2,2,2}, 3),
                    Arguments.of(new int[]{3,-1,-5,-9}, 3),
                    Arguments.of(new int[]{-6,-2,1,4,7,10}, 6),
                    Arguments.of(new int[]{-6,-2,1,6,7,10}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void numberOfArithmeticSlices(int[] nums, int result) {
        Assertions.assertEquals(result, new Q413().numberOfArithmeticSlices1(nums));
        Assertions.assertEquals(result, new Q413().numberOfArithmeticSlices2(nums));
        Assertions.assertEquals(result, new Q413().numberOfArithmeticSlices(nums));
    }
}