package com.cshawn.codes.leetcodes.everyday;


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
 * @date 2021/2/5 3:39 下午
 */
class Q1Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,5,4,3}, 8, new int[]{0,1}),
                    Arguments.of(new int[]{9,9,10,10,5,7}, 20, new int[]{2,3}),
                    Arguments.of(new int[]{1,2}, 9, new int[0])
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void twoSum(int[] nums, int target, int[] result) {
        int[] res = new Q1().twoSum(nums, target);
        Arrays.sort(res);
        Assertions.assertArrayEquals(result, res);
    }
}