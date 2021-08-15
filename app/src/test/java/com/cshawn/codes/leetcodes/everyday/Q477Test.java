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
 * @date 2021/5/28 3:11 下午
 */
class Q477Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1}, 0),
                    Arguments.of(new int[]{1,2}, 2),
                    Arguments.of(new int[]{1,1}, 0),
                    Arguments.of(new int[]{1,1,2,2}, 8),
                    Arguments.of(new int[]{3,2,1,2,3,4}, 22),
                    Arguments.of(new int[]{2,2,3,3,4,7,7}, 30),
                    Arguments.of(new int[]{4,14,2}, 6)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void totalHammingDistance(int[] nums, int result) {
        Assertions.assertEquals(result, new Q477().totalHammingDistance(nums));
    }
}