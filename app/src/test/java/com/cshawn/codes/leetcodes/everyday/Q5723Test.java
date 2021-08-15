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
 * @date 2021/4/4 12:48 下午
 */
class Q5723Test {

    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}}, 5, new int[]{0,2,0,0,0}),
                    Arguments.of(new int[][]{{1,1},{2,2},{2,3}}, 4, new int[]{1,1,0,0})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findingUsersActiveMinutes(int[][] logs, int k, int[] result) {
        Assertions.assertArrayEquals(result, new Q5723().findingUsersActiveMinutes(logs, k));
    }
}