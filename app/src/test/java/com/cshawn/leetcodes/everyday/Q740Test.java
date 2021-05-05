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
 * @date 2021/5/5 9:28 下午
 */
class Q740Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,4,2}, 6),
                    Arguments.of(new int[]{2,2,3,3,3,4}, 9),
                    Arguments.of(new int[]{1}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void deleteAndEarn(int[] nums, int result) {
        Assertions.assertEquals(result, new Q740().deleteAndEarn1(nums));
        Assertions.assertEquals(result, new Q740().deleteAndEarn(nums));
    }
}