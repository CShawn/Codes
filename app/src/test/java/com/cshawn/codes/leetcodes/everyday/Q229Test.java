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
 * @date 2021/10/22 5:49 下午
 */
class Q229Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3}, new Integer[]{3}),
                    Arguments.of(new int[]{1,3}, new Integer[]{1,3}),
                    Arguments.of(new int[]{3,2,3}, new Integer[]{3}),
                    Arguments.of(new int[]{1,2,3}, new Integer[0]),
                    Arguments.of(new int[]{2,1,1,3,1,4,5,6}, new Integer[]{1}),
                    Arguments.of(new int[]{1,1,1,3,3,2,2,2}, new Integer[]{1, 2})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void majorityElement(int[] nums, Integer[] result) {
        assertArrayEquals(result, new Q229().majorityElement(nums).toArray());
    }
}