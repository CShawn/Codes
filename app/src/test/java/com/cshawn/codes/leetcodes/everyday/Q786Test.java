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
 * @date 2021/11/29 9:28 上午
 */
class Q786Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,5}, 1, new int[]{1,5}),
                    Arguments.of(new int[]{1,2,3,5}, 2, new int[]{1,3}),
                    Arguments.of(new int[]{1,2,3,5}, 3, new int[]{2,5}),
                    Arguments.of(new int[]{1,2,3,5}, 4, new int[]{1,2}),
                    Arguments.of(new int[]{1,2,3,5}, 5, new int[]{3,5}),
                    Arguments.of(new int[]{1,2,3,5}, 6, new int[]{2,3}),
                    Arguments.of(new int[]{1,7,11}, 1, new int[]{1, 11}),
                    Arguments.of(new int[]{1,7,11}, 2, new int[]{1, 7}),
                    Arguments.of(new int[]{1,7,11}, 3, new int[]{7, 11}),
                    Arguments.of(new int[]{1,7,23,29,47}, 8, new int[]{23, 47})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void kthSmallestPrimeFraction(int[] arr, int k, int[] result) {
        Assertions.assertArrayEquals(result, new Q786().kthSmallestPrimeFraction1(arr, k));
        Assertions.assertArrayEquals(result, new Q786().kthSmallestPrimeFraction(arr, k));
    }
}