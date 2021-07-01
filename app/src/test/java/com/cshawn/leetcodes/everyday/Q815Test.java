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
 * @date 2021/6/28 4:41 下午
 */
class Q815Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6, 2),
                    Arguments.of(new int[][]{{1, 7}, {3, 6}}, 6, 6, 0),
                    Arguments.of(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12, -1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void numBusesToDestination(int[][] routes, int source, int target, int result) {
        Assertions.assertEquals(result, new Q815().numBusesToDestination1(routes, source, target));
        Assertions.assertEquals(result, new Q815().numBusesToDestination(routes, source, target));
    }
}