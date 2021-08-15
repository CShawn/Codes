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
 * @date 2021/2/21 9:19 下午
 */
class Q1438Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 1, 0),
                    Arguments.of(new int[0], 0, 0),
                    Arguments.of(new int[0], -1, 0),
                    Arguments.of(new int[]{8}, 0, 1),
                    Arguments.of(new int[]{8}, 1, 1),
                    Arguments.of(new int[]{8}, 4, 1),
                    Arguments.of(new int[]{8}, -1, 0),
                    Arguments.of(new int[]{1,2}, 0, 1),
                    Arguments.of(new int[]{1,2}, 1, 2),
                    Arguments.of(new int[]{1,2}, 2, 2),
                    Arguments.of(new int[]{1,2,3,8,9}, 2, 3),
                    Arguments.of(new int[]{8,2,4,7}, 4, 2),
                    Arguments.of(new int[]{8,2,4,2,7}, 4, 3),
                    Arguments.of(new int[]{8,2,4,7}, 0, 1),
                    Arguments.of(new int[]{10,1,2,4,7,2}, 5, 4),
                    Arguments.of(new int[]{4,2,2,2,4,4,2,2}, 0, 3),
                    Arguments.of(new int[]{24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,21,33,68,22,85,35,83,92,38,59,90,42,64,61,15,4,40,50,44,54,25,34,14,33,94,66,27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39}, 87, 25)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void longestSubarray(int[] nums, int limit, int result) {
        Assertions.assertEquals(result, new Q1438().longestSubarray(nums, limit));
    }
}