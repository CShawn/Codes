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
 * @date 2021/2/6 12:24 下午
 */
class Q1423Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 3, 0),
                    Arguments.of(new int[]{1,2,3,4,5,6,1}, 0, 0),
                    Arguments.of(new int[]{1,2,3}, 5, 6),
                    Arguments.of(new int[]{1,2,3,4,5,6,1}, 3, 12),
                    Arguments.of(new int[]{9,7,7,9,7,7,9}, 7, 55),
                    Arguments.of(new int[]{1,1000,1}, 1, 1),
                    Arguments.of(new int[]{1,79,80,1,1,1,200,1}, 3, 202)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxScore1(int[] nums, int k, int max) {
        Assertions.assertEquals(max, new Q1423().maxScore1(nums, k));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxScore2(int[] nums, int k, int max) {
        Assertions.assertEquals(max, new Q1423().maxScore2(nums, k));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxScore(int[] nums, int k, int max) {
        Assertions.assertEquals(max, new Q1423().maxScore(nums, k));
    }
}