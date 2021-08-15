package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/4/6 4:33 下午
 */
class Q27Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,3,2,2}, 3, 2, new int[]{2,2}),
                    Arguments.of(new int[]{3,2,2,3}, 3, 2, new int[]{2,2}),
                    Arguments.of(new int[]{1,2,3,4}, 1, 3, new int[]{4,2,3}),
                    Arguments.of(new int[]{1,1,1,2,2,3}, 1, 3, new int[]{3,2,2}),
                    Arguments.of(new int[]{1,1,1,2,2,3,1,1}, 1, 3, new int[]{3,2,2}),
                    Arguments.of(new int[]{0,0,1,1,2,3,3}, 3, 5, new int[]{0,0,1,1,2}),
                    Arguments.of(new int[]{0,0,1,1,3,2}, 1, 4, new int[]{0,0,2,3}),
                    Arguments.of(new int[]{1}, 1, 0, new int[0]),
                    Arguments.of(new int[]{1,1,1}, 1, 0, new int[0]),
                    Arguments.of(new int[]{1}, 2, 1, new int[]{1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeElement1(int[] nums, int val, int result, int[] array) {
        int res = new Q27().removeElement1(nums, val);
        Assertions.assertEquals(result ,res);
        int[] sub = new int[result];
        System.arraycopy(nums, 0, sub, 0, result);
        Assertions.assertArrayEquals(sub, array);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeElement2(int[] nums, int val, int result, int[] array) {
        int res = new Q27().removeElement2(nums, val);
        Assertions.assertEquals(result ,res);
        int[] sub = new int[result];
        System.arraycopy(nums, 0, sub, 0, result);
        Assertions.assertArrayEquals(sub, array);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeElement(int[] nums, int val, int result, int[] array) {
        int res = new Q27().removeElement(nums, val);
        Assertions.assertEquals(result ,res);
        int[] sub = new int[result];
        System.arraycopy(nums, 0, sub, 0, result);
        Assertions.assertArrayEquals(sub, array);
    }
}