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
 * @date 2021/2/16 9:17 上午
 */
class Q561Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2}, 1),
                    Arguments.of(new int[]{1,3,2,4}, 4),
                    Arguments.of(new int[]{2,1,2,2}, 3),
                    Arguments.of(new int[]{6,2,6,5,1,2}, 9)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void arrayPairSum(int[] nums, int result) {
        Assertions.assertEquals(result, new Q561().arrayPairSum(nums));
    }
}