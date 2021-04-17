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
 * @date 2021/4/17 11:37 下午
 */
class Q5719Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,1,1,3}, 2, new int[]{0,3,2,3}),
                    Arguments.of(new int[]{2,3,4,7}, 3, new int[]{5,2,6,5}),
                    Arguments.of(new int[]{0,1,2,2,5,7}, 3, new int[]{4,3,6,4,6,7})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void getMaximumXor(int[] nums, int maximumBit, int[] result) {
        Assertions.assertArrayEquals(result, new Q5719().getMaximumXor(nums, maximumBit));
    }
}