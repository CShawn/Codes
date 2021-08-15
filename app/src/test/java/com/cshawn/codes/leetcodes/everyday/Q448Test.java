package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/2/13 10:22 下午
 */
class Q448Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], new int[0]),
                    Arguments.of(new int[]{1}, new int[0]),
                    Arguments.of(new int[]{1,2}, new int[0]),
                    Arguments.of(new int[]{1,1}, new int[]{2}),
                    Arguments.of(new int[]{1,2}, new int[0]),
                    Arguments.of(new int[]{1,1,2,2}, new int[]{3,4}),
                    Arguments.of(new int[]{3,2,1,2,3,4}, new int[]{5,6}),
                    Arguments.of(new int[]{2,2,3,3,4,7,7}, new int[]{1,5,6})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findDisappearedNumbers(int[] nums, int[] result) {
        List<Integer> list = new Q448().findDisappearedNumbers(nums);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Assertions.assertArrayEquals(result, arr);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findDisappearedNumbers1(int[] nums, int[] result) {
        List<Integer> list = new Q448().findDisappearedNumbers1(nums);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Assertions.assertArrayEquals(result, arr);
    }
}