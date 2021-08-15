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
 * @date 2021/7/13 5:37 下午
 */
class Q218Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(
                            new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}},
                            new Integer[][]{{2,10},{3,15},{7,12},{12,0},{15,10},{20,8},{24,0}}
                    ),
                    Arguments.of(new int[][]{{0,2,3},{2,5,3}}, new Integer[][]{{0,3},{5,0}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void getSkyline(int[][] buildings, Integer[][] result) {
        List<List<Integer>> list = new Q218().getSkyline(buildings);
        Integer[][] arr = new Integer[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, arr);
    }
}