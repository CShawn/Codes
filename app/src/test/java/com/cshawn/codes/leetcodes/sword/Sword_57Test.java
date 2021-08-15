package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/1/24 9:13 下午
 */
class Sword_57Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,5}, 8, new int[]{3,5}),
                    Arguments.of(new int[]{1,3,5}, 6, new int[]{1,5}),
                    Arguments.of(new int[]{1,3,5}, 9, new int[0])
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void twoSum(int[] nums, int target, int[] result) {
        int[] res = new Sword_57().twoSum(nums, target);
        Arrays.sort(res);
        Assertions.assertArrayEquals(result, res);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void twoSum2(int[] nums, int target, int[] result) {
        int[] res = new Sword_57().twoSum2(nums, target);
        Arrays.sort(res);
        Assertions.assertArrayEquals(result, res);
    }
}