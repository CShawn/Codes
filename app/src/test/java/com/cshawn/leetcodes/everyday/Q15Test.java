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
 * @date 2021/7/6 6:11 下午
 */
class Q15Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{-1,0,1,2,-1,-4}, new Integer[][]{{-1,-1,2},{-1,0,1}}),
                    Arguments.of(new int[]{0}, new Integer[0][]),
                    Arguments.of(new int[0], new Integer[0][])
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void threeSum(int[] nums, Integer[][] result) {
        List<List<Integer>> list = new Q15().threeSum(nums);
        Integer[][] res = new Integer[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }
}