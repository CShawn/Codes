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
 * @date 2021/3/24 8:39 上午
 */
class Q456Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[0], false),
                    Arguments.arguments(new int[]{1}, false),
                    Arguments.arguments(new int[]{1, 2}, false),
                    Arguments.arguments(new int[]{1, 2, 3}, false),
                    Arguments.arguments(new int[]{1, 3, 2}, true),
                    Arguments.arguments(new int[]{-1, 1, 0}, true),
                    Arguments.arguments(new int[]{-4, -2, -3}, true),
                    Arguments.arguments(new int[]{1, 2, 3, 4}, false),
                    Arguments.arguments(new int[]{3, 1, 4, 2}, true),
                    Arguments.arguments(new int[]{2, 4, 3, 1}, true),
                    Arguments.arguments(new int[]{-1, 3, 2, 0}, true),
                    Arguments.arguments(new int[]{3, 5, 0, 3, 4}, true),
                    Arguments.arguments(new int[]{1, 2, 3, 5, 4, 2}, true),
                    Arguments.arguments(new int[]{1, 3, 0, -2, 5, 9}, false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void find132pattern(int[] nums, boolean result) {
        Assertions.assertEquals(result, new Q456().find132pattern(nums));
    }
}