package com.cshawn.codes.leetcodes.lcp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/7/1 7:00 下午
 */
class Q7Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(5, new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}}, 3, 3),
                    Arguments.of(3, new int[][]{{0,2},{2,1}}, 2, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void numWays(int n, int[][] relation, int k, int result) {
        Assertions.assertEquals(result, new Q7().numWays1(n, relation, k));
        Assertions.assertEquals(result, new Q7().numWays2(n, relation, k));
        Assertions.assertEquals(result, new Q7().numWays3(n, relation, k));
        Assertions.assertEquals(result, new Q7().numWays(n, relation, k));
    }
}