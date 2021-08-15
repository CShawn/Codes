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
 * @date 2021/4/24 12:50 下午
 */
class Q377Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1}, 4, 1),
                    Arguments.of(new int[]{2}, 3, 0),
                    Arguments.of(new int[]{2}, 2, 1),
                    Arguments.of(new int[]{2,3}, 5, 2),
                    Arguments.of(new int[]{2,3}, 3, 1),
                    Arguments.of(new int[]{2,3}, 2, 1),
                    Arguments.of(new int[]{2,3}, 6, 2),
                    Arguments.of(new int[]{2,3}, 7, 3),
                    Arguments.of(new int[]{1,2,3}, 4, 7),
                    Arguments.of(new int[]{9}, 3, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void combinationSum4(int[] nums, int target, int result) {
        Assertions.assertEquals(result, new Q377().combinationSum4(nums, target));
        Assertions.assertEquals(result, new Q377().combinationSum41(nums, target));
    }
}