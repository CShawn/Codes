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
 * @date 2021/5/12 1:58 下午
 */
class Q1310Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}}, new int[]{2,7,14,8}),
                    Arguments.of(new int[]{4,8,2,10}, new int[][]{{2,3},{1,3},{0,0},{0,3}}, new int[]{8,0,4,4})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void xorQueries(int[] arr, int[][] queries, int[] result) {
        Assertions.assertArrayEquals(result, new Q1310().xorQueries1(arr, queries));
        Assertions.assertArrayEquals(result, new Q1310().xorQueries(arr, queries));
    }
}