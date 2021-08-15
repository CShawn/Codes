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
 * @date 2021/2/9 10:23 上午
 */
class Q992Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 1, 0),
                    Arguments.of(new int[]{1}, 0, 0),
                    Arguments.of(new int[]{1,2}, 1, 2),
                    Arguments.of(new int[]{1,1}, 1, 3),
                    Arguments.of(new int[]{1,2,1}, 1, 3),
                    Arguments.of(new int[]{1,1,1}, 1, 6),
                    Arguments.of(new int[]{1,1,2}, 1, 4),
                    Arguments.of(new int[]{1,1,2}, 2, 2),
                    Arguments.of(new int[]{1,2,2}, 3, 0),
                    Arguments.of(new int[]{1,2,3}, 1, 3),
                    Arguments.of(new int[]{1,2,3}, 2, 2),
                    Arguments.of(new int[]{1,2,3}, 3, 1),
                    Arguments.of(new int[]{1,2,3}, 4, 0),
                    Arguments.of(new int[]{1,2,1,2,3}, 2, 7),
                    Arguments.of(new int[]{1,2,1,3,4}, 3, 3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void subarraysWithKDistinct(int[] nums, int k, int result) {
        Assertions.assertEquals(result, new Q992().subarraysWithKDistinct(nums, k));
    }
}