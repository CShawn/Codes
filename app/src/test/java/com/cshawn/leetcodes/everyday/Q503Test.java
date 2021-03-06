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
 * @date 2021/3/6 11:22 上午
 */
class Q503Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], new int[0]),
                    Arguments.of(new int[]{1}, new int[]{-1}),
                    Arguments.of(new int[]{1,2,1}, new int[]{2,-1,2}),
                    Arguments.of(new int[]{1,2,3}, new int[]{2,3,-1}),
                    Arguments.of(new int[]{1,3,2}, new int[]{3,-1,3}),
                    Arguments.of(new int[]{1,1,1}, new int[]{-1,-1,-1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void nextGreaterElements(int[] nums, int[] result) {
        assertArrayEquals(result, new Q503().nextGreaterElements1(nums));
        assertArrayEquals(result, new Q503().nextGreaterElements(nums));
    }
}