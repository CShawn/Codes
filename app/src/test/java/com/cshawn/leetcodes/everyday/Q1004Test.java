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
 * @date 2021/2/19 8:56 下午
 */
class Q1004Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 0, 4),
                    Arguments.of(new int[]{1,1,1,0,1,1,1,1,0}, 1, 8),
                    Arguments.of(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2, 6),
                    Arguments.of(new int[]{1,1,1,0,0,0,1,1,1,1,0,0,0,0}, 3, 10),
                    Arguments.of(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3, 10),
                    Arguments.of(new int[]{0,0,0,1}, 4, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void longestOnes(int[] nums, int k, int result) {
        Assertions.assertEquals(result, new Q1004().longestOnes(nums, k));
    }
}