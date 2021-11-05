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
 * @date 2021/11/5 10:19 上午
 */
class Q1218Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,4}, 1, 4),
                    Arguments.of(new int[]{1,3,5,7}, 1, 1),
                    Arguments.of(new int[]{1,5,7,8,5,3,4,2,1}, -2, 4),
                    Arguments.of(new int[]{3,4,-3,-2,-4}, -5, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void longestSubsequence(int[] arr, int difference, int result) {
        assertEquals(result, new Q1218().longestSubsequence1(arr, difference));
        assertEquals(result, new Q1218().longestSubsequence(arr, difference));
    }
}