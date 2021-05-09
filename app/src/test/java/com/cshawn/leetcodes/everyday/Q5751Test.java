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
 * @date 2021/5/9 12:19 下午
 */
class Q5751Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}, 2),
                    Arguments.of(new int[]{2,2,2}, new int[]{10,10,1}, 1),
                    Arguments.of(new int[]{30,29,19,5}, new int[]{25,25,25,25,25}, 2),
                    Arguments.of(new int[]{5,4}, new int[]{3, 2}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxDistance(int[] nums1, int[] nums2, int result) {
        Assertions.assertEquals(result, new Q5751().maxDistance1(nums1, nums2));
        Assertions.assertEquals(result, new Q5751().maxDistance(nums1, nums2));
    }
}