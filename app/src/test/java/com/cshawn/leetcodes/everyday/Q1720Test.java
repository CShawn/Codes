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
 * @date 2021/5/6 6:17 下午
 */
class Q1720Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3}, 1, new int[]{1,0,2,1}),
                    Arguments.of(new int[]{6,2,7,3}, 4, new int[]{4,2,0,7,4})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void decode(int[] nums, int first, int[] result) {
        Assertions.assertArrayEquals(result, new Q1720().decode1(nums, first));
        Assertions.assertArrayEquals(result, new Q1720().decode(nums, first));
    }
}