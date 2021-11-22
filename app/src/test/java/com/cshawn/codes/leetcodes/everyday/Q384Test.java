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
 * @date 2021/11/22 8:39 上午
 */
class Q384Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((Object) new int[]{0,1,3,5,6,8,12,17}),
                    Arguments.of((Object) new int[]{0,1,2,3,4,8,9,11}),
                    Arguments.of((Object) new int[]{0,1}),
                    Arguments.of((Object) new int[]{0,1,3}),
                    Arguments.of((Object) new int[]{1,1}),
                    Arguments.of((Object) new int[]{1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void test(int[] nums) {
        Q384.Solution test = new Q384.Solution(nums);
        Assertions.assertArrayEquals(nums, test.reset());
        int[] t1 = test.shuffle1();
        Arrays.sort(t1);
        Assertions.assertArrayEquals(nums, t1);
        int[] t2 = test.shuffle2();
        Arrays.sort(t2);
        Assertions.assertArrayEquals(nums, t2);
        int[] t3 = test.shuffle();
        Arrays.sort(t3);
        Assertions.assertArrayEquals(nums, t3);
        Assertions.assertArrayEquals(nums, test.reset());
    }
}