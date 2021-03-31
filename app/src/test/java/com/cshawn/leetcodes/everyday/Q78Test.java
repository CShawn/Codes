package com.cshawn.leetcodes.everyday;

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
 * @date 2021/3/31 11:03 上午
 */
class Q78Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{1}, new Integer[][]{{},{1}}),
                    Arguments.arguments(new int[]{1,2}, new Integer[][]{{},{1},{2},{1,2}}),
                    Arguments.arguments(new int[]{1,2,3}, new Integer[][]{{},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}})
            );
        }
    }

    static class DataArgumentProvider2 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{1}, new Integer[][]{{1},{}}),
                    Arguments.arguments(new int[]{1,2}, new Integer[][]{{1,2},{1},{2},{}}),
                    Arguments.arguments(new int[]{1,2,3}, new Integer[][]{{1,2,3},{1,2},{1,3},{1},{2,3},{2},{3},{}})
            );
        }
    }

    static class DataArgumentProvider3 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{1}, new Integer[][]{{},{1}}),
                    Arguments.arguments(new int[]{1,2}, new Integer[][]{{},{1},{2},{1,2}}),
                    Arguments.arguments(new int[]{1,2,3}, new Integer[][]{{},{1},{2},{1,2},{3},{1,3},{2,3},{1,2,3}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void subsets1(int[] nums, Integer[][] result) {
        List<List<Integer>> lists = new Q78().subsets1(nums);
        Integer[][] res = new Integer[lists.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = lists.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider2.class)
    void subsets2(int[] nums, Integer[][] result) {
        List<List<Integer>> lists = new Q78().subsets2(nums);
        Integer[][] res = new Integer[lists.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = lists.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider3.class)
    void subsets(int[] nums, Integer[][] result) {
        List<List<Integer>> lists = new Q78().subsets(nums);
        Integer[][] res = new Integer[lists.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = lists.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }
}