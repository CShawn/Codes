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
 * @date 2021/4/6 3:57 下午
 */
class Q26Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3}, 3, new int[]{1,2,3}),
                    Arguments.of(new int[]{1,1,1,2,2,3}, 3, new int[]{1,2,3}),
                    Arguments.of(new int[]{0,0,1,1,1,1,2,3,3}, 4, new int[]{0,1,2,3})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeDuplicates1(int[] nums, int result, int[] array) {
        new Q26().removeDuplicates1(nums);
        int[] sub = new int[result];
        System.arraycopy(nums, 0, sub, 0, result);
        Assertions.assertArrayEquals(sub, array);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeDuplicates(int[] nums, int result, int[] array) {
        new Q26().removeDuplicates(nums);
        int[] sub = new int[result];
        System.arraycopy(nums, 0, sub, 0, result);
        Assertions.assertArrayEquals(sub, array);
    }
}