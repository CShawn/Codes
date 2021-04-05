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
 * @date 2021/4/5 7:09 下午
 */
class Q88Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3, new int[]{1,2,2,3,5,6}),
                    Arguments.of(new int[]{1}, 1, new int[0], 0, new int[]{1}),
                    Arguments.of(new int[]{0}, 0, new int[]{2}, 1, new int[]{2}),
                    Arguments.of(new int[]{2,3,0,0}, 2, new int[]{1,2}, 2, new int[]{1,2,2,3}),
                    Arguments.of(new int[]{2,3,0,0}, 2, new int[]{1,3}, 2, new int[]{1,2,3,3})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void merge(int[] nums1, int m, int[] nums2, int n, int[] result) {
        new Q88().merge(nums1, m, nums2, n);
        Assertions.assertArrayEquals(result, nums1);
    }
}