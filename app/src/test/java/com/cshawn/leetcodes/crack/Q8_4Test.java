package com.cshawn.leetcodes.crack;

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
 * @date 2021/3/28 6:42 下午
 */
class Q8_4Test {

    static class DataArgumentProvider1 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{1}, new int[][]{{}, {1}}),
                    Arguments.arguments(new int[]{1,2}, new int[][]{{}, {1},{2},{1,2}}),
                    Arguments.arguments(new int[]{1,2,3}, new int[][]{{}, {1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}})
            );
        }
    }

    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{1}, new int[][]{{}, {1}}),
                    Arguments.arguments(new int[]{1,2}, new int[][]{{}, {1},{1,2},{2}}),
                    Arguments.arguments(new int[]{1,2,3}, new int[][]{{}, {1},{1,2},{1,2,3},{1,3},{2},{2,3},{3}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider1.class)
    void subsets1(int[] nums, int[][] result) {
        List<List<Integer>> results = new Q8_4().subsets1(nums);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertArrayEquals(result[i], results.get(i).stream().mapToInt(Integer::intValue).toArray());
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void subsets(int[] nums, int[][] result) {
        List<List<Integer>> results = new Q8_4().subsets(nums);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertArrayEquals(result[i], results.get(i).stream().mapToInt(Integer::intValue).toArray());
        }
    }
}