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
 * @date 2021/6/3 8:59 下午
 */
class Q525Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,1}, 2),
                    Arguments.of(new int[]{0,1,0}, 2),
                    Arguments.of(new int[]{0,0}, 0),
                    Arguments.of(new int[]{1,1,1}, 0),
                    Arguments.of(new int[]{1,1,1,0,0}, 4),
                    Arguments.of(new int[]{1,1,1,0,0,0,1}, 6),
                    Arguments.of(new int[]{1,1,1,1,0}, 2),
                    Arguments.of(new int[]{1,1,1,0,0,0,1,0}, 8)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findMaxLength(int[] nums, int result) {
        Assertions.assertEquals(result, new Q525().findMaxLength1(nums));
        Assertions.assertEquals(result, new Q525().findMaxLength(nums));
    }
}