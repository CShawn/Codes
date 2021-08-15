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
 * @date 2021/7/19 6:08 下午
 */
class Q1838Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,4}, 5, 3),
                    Arguments.of(new int[]{1,4,8,13}, 5, 2),
                    Arguments.of(new int[]{1,4,8,13}, 1, 1),
                    Arguments.of(new int[]{3,9,6},2,1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxFrequency(int[] nums, int k, int result) {
        Assertions.assertEquals(result, new Q1838().maxFrequency(nums, k));
    }
}