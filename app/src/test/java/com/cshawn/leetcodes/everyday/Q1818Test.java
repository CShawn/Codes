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
 * @date 2021/7/14 4:17 下午
 */
class Q1818Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,7,5}, new int[]{2,3,5}, 3),
                    Arguments.of(new int[]{2,4,6,8,10}, new int[]{2,4,6,8,10}, 0),
                    Arguments.of(new int[]{1,10,4,4,2,7}, new int[]{9,3,5,1,7,4}, 20),
                    Arguments.of(new int[]{1,28,21}, new int[]{9,21,20}, 9)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minAbsoluteSumDiff(int[] nums1, int[] nums2, int result) {
        Assertions.assertEquals(result, new Q1818().minAbsoluteSumDiff(nums1, nums2));
    }
}