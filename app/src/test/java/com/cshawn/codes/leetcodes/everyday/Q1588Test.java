package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/8/29 11:17 上午
 */
class Q1588Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,4,2,5,3}, 58),
                    Arguments.of(new int[]{10,11,12}, 66),
                    Arguments.of(new int[]{1,2}, 3),
                    Arguments.of(new int[]{1}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void sumOddLengthSubarrays(int[] arr, int result) {
        assertEquals(result, new Q1588().sumOddLengthSubarrays1(arr));
        assertEquals(result, new Q1588().sumOddLengthSubarrays2(arr));
        assertEquals(result, new Q1588().sumOddLengthSubarrays(arr));
    }
}