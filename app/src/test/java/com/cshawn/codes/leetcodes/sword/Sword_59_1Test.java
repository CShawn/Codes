package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/1/25 7:09 下午
 */
class Sword_59_1Test {

    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,5,-9,1}, 2, new int[]{5,5,1}),
                    Arguments.of(new int[]{1,3,5}, 3, new int[]{5}),
                    Arguments.of(new int[]{1}, 1, new int[]{1}),
                    Arguments.of(new int[]{1,5,-4,6,2,9,1}, 2, new int[]{5,5,6,6,9,9})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxSlidingWindow(int[] nums, int k, int[] result) {
        Assertions.assertArrayEquals(result, new Sword_59_1().maxSlidingWindow(nums, k));
    }
}