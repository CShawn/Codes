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
 * @date 2021/5/21 6:03 下午
 */
class Q1035Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,4,2}, new int[]{1,2,4}, 2),
                    Arguments.of(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}, 3),
                    Arguments.of(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxUncrossedLines1(int[] nums1, int[] nums2, int result) {
        Assertions.assertEquals(result, new Q1035().maxUncrossedLines1(nums1, nums2));
        Assertions.assertEquals(result, new Q1035().maxUncrossedLines(nums1, nums2));
    }
}