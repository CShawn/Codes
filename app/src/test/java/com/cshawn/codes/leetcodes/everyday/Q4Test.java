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
 * @date 2021/2/8 4:34 下午
 */
class Q4Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], new int[0], 0),
                    Arguments.of(new int[]{1}, new int[0], 1),
                    Arguments.of(new int[0], new int[]{1}, 1),
                    Arguments.of(new int[]{1,3}, new int[]{2}, 2),
                    Arguments.of(new int[]{1,2}, new int[]{3,4}, 2.5),
                    Arguments.of(new int[]{1,3}, new int[]{2,4}, 2.5),
                    Arguments.of(new int[]{1,1}, new int[]{1,1}, 1),
                    Arguments.of(new int[]{2,3,4,5}, new int[0], 3.5),
                    Arguments.of(new int[]{0,0,0,0,0}, new int[]{-1,0,0,0,0,0,1}, 0),
                    Arguments.of(new int[]{1,2,2}, new int[]{1,2,3}, 2),
                    Arguments.of(new int[]{1,2,3,4,5,6}, new int[0], 3.5)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findMedianSortedArrays(int[] nums1, int[] nums2, double result) {
        Assertions.assertEquals(result, new Q4().findMedianSortedArrays(nums1, nums2));
    }
}