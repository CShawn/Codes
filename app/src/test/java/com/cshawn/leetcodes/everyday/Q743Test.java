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
 * @date 2021/8/2 4:23 下午
 */
class Q743Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2, 2),
                    Arguments.of(new int[][]{{1,2,1}}, 2, 1, 1),
                    Arguments.of(new int[][]{{1,2,1}}, 2, 2, -1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void networkDelayTime(int[][] times, int n, int k, int result) {
        Assertions.assertEquals(result, new Q743().networkDelayTime1(times, n, k));
        Assertions.assertEquals(result, new Q743().networkDelayTime(times, n, k));
    }
}