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
 * @date 2021/2/28 10:33 上午
 */
class Q896Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], false),
                    Arguments.of(new int[]{1}, true),
                    Arguments.of(new int[]{1,1}, true),
                    Arguments.of(new int[]{1,1,1}, true),
                    Arguments.of(new int[]{1,2,3,3,3}, true),
                    Arguments.of(new int[]{1,1,1,2,3}, true),
                    Arguments.of(new int[]{1,2,3,4}, true),
                    Arguments.of(new int[]{1,2,2,2,3}, true),
                    Arguments.of(new int[]{5,4,3,3,3}, true),
                    Arguments.of(new int[]{1,1,1,0,-3}, true),
                    Arguments.of(new int[]{4,3,2,1}, true),
                    Arguments.of(new int[]{3,2,2,2,1}, true),
                    Arguments.of(new int[]{1,3,2}, false),
                    Arguments.of(new int[]{1,2,2,3,3,4,3}, false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isMonotonic(int[] a, boolean result) {
        Assertions.assertEquals(result, new Q896().isMonotonic1(a));
        Assertions.assertEquals(result, new Q896().isMonotonic(a));
    }
}