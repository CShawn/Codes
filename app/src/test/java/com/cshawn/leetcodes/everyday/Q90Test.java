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
 * @date 2021/3/31 10:11 上午
 */
class Q90Test {
    static class DataArgumentProvider1 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{1}, new Integer[][]{{},{1}}),
                    Arguments.arguments(new int[]{1,2}, new Integer[][]{{},{2},{1},{1,2}}),
                    Arguments.arguments(new int[]{1,2,2}, new Integer[][]{{},{2},{2,2},{1},{1,2},{1,2,2}})
            );
        }
    }

    static class DataArgumentProvider2 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{1}, new Integer[][]{{},{1}}),
                    Arguments.arguments(new int[]{1,2}, new Integer[][]{{},{1},{2},{1,2}}),
                    Arguments.arguments(new int[]{1,2,2}, new Integer[][]{{},{1},{2},{1,2},{2,2},{1,2,2}})
            );
        }
    }

    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{1}, new Integer[][]{{},{1}}),
                    Arguments.arguments(new int[]{1,2}, new Integer[][]{{},{1},{1,2},{2}}),
                    Arguments.arguments(new int[]{1,2,2}, new Integer[][]{{},{1},{1,2},{1,2,2},{2},{2,2}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider1.class)
    void subsetsWithDup1(int[] nums, Integer[][] result) {
        List<List<Integer>> lists = new Q90().subsetsWithDup1(nums);
        Integer[][] res = new Integer[lists.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = lists.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider2.class)
    void subsetsWithDup2(int[] nums, Integer[][] result) {
        List<List<Integer>> lists = new Q90().subsetsWithDup2(nums);
        Integer[][] res = new Integer[lists.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = lists.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void subsetsWithDup(int[] nums, Integer[][] result) {
        List<List<Integer>> lists = new Q90().subsetsWithDup(nums);
        Integer[][] res = new Integer[lists.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = lists.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }
}