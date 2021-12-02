package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author C.Shawn
 * @date 2021/12/2 11:17 上午
 */
class Q506Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1}, new String[]{"Gold Medal"}),
                    Arguments.of(new int[]{1,2}, new String[]{"Silver Medal","Gold Medal"}),
                    Arguments.of(new int[]{1,3,2}, new String[]{"Bronze Medal","Gold Medal", "Silver Medal"}),
                    Arguments.of(new int[]{1,2,3,4}, new String[]{"4","Bronze Medal","Silver Medal","Gold Medal"}),
                    Arguments.of(new int[]{10,3,8,9,4}, new String[]{"Gold Medal","5","Bronze Medal","Silver Medal","4"})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findRelativeRanks(int[] score, String[] result) {
        assertArrayEquals(result, new Q506().findRelativeRanks1(score));
        assertArrayEquals(result, new Q506().findRelativeRanks(score));
    }
}