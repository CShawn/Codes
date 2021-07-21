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
 * @date 2021/7/21 5:36 下午
 */
class Q18Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,0,-1,0,-2,2}, 0, new Integer[][]{{-2,-1,1,2},{-2,0,0,2},{-1,0,0,1}}),
                    Arguments.of(new int[0], 0, new Integer[0][]),
                    Arguments.of(new int[]{1,2,3,4,5,6,7}, 1, new Integer[0][]),
                    Arguments.of(new int[]{1,2,3,4,5,6,7}, 15, new Integer[][]{{1,2,5,7}, {1,3,4,7}, {1,3,5,6}, {2,3,4,6}}),
                    Arguments.of(new int[]{1,-2,-5,-4,-3,3,3,5}, -11, new Integer[][]{{-5,-4,-3,1}}),
                    Arguments.of(new int[]{2,2,2,2,2,2}, 8, new Integer[][]{{2,2,2,2}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void fourSum(int[] nums, int target, Integer[][] result) {
        List<List<Integer>> list = new Q18().fourSum(nums, target);
        Integer[][] res = new Integer[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }
}