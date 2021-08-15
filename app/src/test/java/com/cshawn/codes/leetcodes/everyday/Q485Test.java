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
 * @date 2021/2/15 9:59 上午
 */
class Q485Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 0),
                    Arguments.of(new int[]{1}, 1),
                    Arguments.of(new int[]{0}, 0),
                    Arguments.of(new int[]{1,0,1}, 1),
                    Arguments.of(new int[]{1,1}, 2),
                    Arguments.of(new int[]{0,0,0}, 0),
                    Arguments.of(new int[]{0,1,0}, 1),
                    Arguments.of(new int[]{1,1,1}, 3),
                    Arguments.of(new int[]{0,1,1,1,0,0,0,0,1,1,1,1}, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findMaxConsecutiveOnes(int[] nums, int result) {
        Assertions.assertEquals(result, new Q485().findMaxConsecutiveOnes(nums));
    }
}