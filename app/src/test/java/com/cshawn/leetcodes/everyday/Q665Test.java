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
 * @date 2021/2/7 12:35 下午
 */
class Q665Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], true),
                    Arguments.of(new int[]{1}, true),
                    Arguments.of(new int[]{1,2}, true),
                    Arguments.of(new int[]{2,2}, true),
                    Arguments.of(new int[]{2,1}, true),
                    Arguments.of(new int[]{1,2,3}, true),
                    Arguments.of(new int[]{1,3,2}, true),
                    Arguments.of(new int[]{2,1,3}, true),
                    Arguments.of(new int[]{2,3,1}, true),
                    Arguments.of(new int[]{3,1,2}, true),
                    Arguments.of(new int[]{3,2,1}, false),
                    Arguments.of(new int[]{1,2,4,3}, true),
                    Arguments.of(new int[]{1,4,2,3}, true),
                    Arguments.of(new int[]{1,4,3,2}, false),
                    Arguments.of(new int[]{2,1,3,4}, true),
                    Arguments.of(new int[]{2,1,4,3}, false),
                    Arguments.of(new int[]{2,3,1,4}, true),
                    Arguments.of(new int[]{2,4,1,3}, false),
                    Arguments.of(new int[]{1,4,1,2}, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void checkPossibility(int[] nums, boolean result) {
        Assertions.assertEquals(result, new Q665().checkPossibility(nums));
    }
}