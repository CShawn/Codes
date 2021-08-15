package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/8/11 9:42 上午
 */
class Q446Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,4}, 3),
                    Arguments.of(new int[]{1,2,3}, 1),
                    Arguments.of(new int[]{1}, 0),
                    Arguments.of(new int[]{7,7,7,7,7}, 16),
                    Arguments.of(new int[]{2,4,6,8,10}, 7),
                    Arguments.of(new int[]{0,2000000000,-294967296}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void numberOfArithmeticSlices(int[] nums, int result) {
        Assertions.assertEquals(result, new Q446().numberOfArithmeticSlices(nums));
    }
}