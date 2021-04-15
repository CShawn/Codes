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
 * @date 2021/4/15 8:15 下午
 */
class Q213Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,1}, 4),
                    Arguments.of(new int[]{2,3,2}, 3),
                    Arguments.of(new int[]{2,3}, 3),
                    Arguments.of(new int[]{2}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void rob(int[] nums, int result) {
        Assertions.assertEquals(result, new Q213().rob1(nums));
        Assertions.assertEquals(result, new Q213().rob(nums));
    }
}