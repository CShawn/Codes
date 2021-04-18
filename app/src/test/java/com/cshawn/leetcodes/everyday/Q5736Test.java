package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/4/18 9:16 下午
 */
class Q5736Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,2},{2,4},{3,2},{4,1}}, new int[]{0,2,3,1}),
                    Arguments.of(new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}}, new int[]{4,3,2,0,1}),
                    Arguments.of(new int[][]{{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},
                            {38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}},
                            new int[]{6,1,2,9,4,10,0,11,5,13,3,8,12,7})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void getOrder(int[][] tasks, int[] result) {
        Assertions.assertArrayEquals(result, new Q5736().getOrder(tasks));
    }
}