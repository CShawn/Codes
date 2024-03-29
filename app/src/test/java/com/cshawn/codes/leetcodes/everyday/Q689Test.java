package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/12/9 10:06 上午
 */
class Q689Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,1,2,6,7,5,1}, 2, new int[]{0,3,5}),
                    Arguments.of(new int[]{1,2,1,2,1,2,1,2,1}, 2, new int[]{0,2,4})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxSumOfThreeSubarrays(int[] nums, int k, int[] result) {
        assertArrayEquals(result, new Q689().maxSumOfThreeSubarrays(nums, k));
    }
}