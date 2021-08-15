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
 * @date 2021/7/16 7:05 下午
 */
class Q34Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{5,7,7,8,8,10}, 8, new int[]{3,4}),
                    Arguments.of(new int[]{5,7,7,8,8,10}, 6, new int[]{-1,-1}),
                    Arguments.of(new int[]{1}, 1, new int[]{0,0}),
                    Arguments.of(new int[]{2,2}, 3, new int[]{-1,-1}),
                    Arguments.of(new int[]{2,2}, 1, new int[]{-1,-1}),
                    Arguments.of(new int[0], 0, new int[]{-1,-1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void searchRange(int[] nums, int target, int[] result) {
        Assertions.assertArrayEquals(result, new Q34().searchRange(nums, target));
    }
}