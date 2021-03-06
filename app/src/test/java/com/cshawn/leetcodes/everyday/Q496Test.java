package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author C.Shawn
 * @date 2021/3/6 7:57 下午
 */
class Q496Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1}, new int[]{1}, new int[]{-1}),
                    Arguments.of(new int[]{1,2}, new int[]{2,1,3}, new int[]{3,3}),
                    Arguments.of(new int[]{2,4}, new int[]{1,2,3,4}, new int[]{3,-1}),
                    Arguments.of(new int[]{4,1,2}, new int[]{1,3,4,2}, new int[]{-1,3,-1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void nextGreaterElement(int[] nums1, int[] nums2, int[] result) {
        assertArrayEquals(result, new Q496().nextGreaterElement(nums1, nums2));
    }
}