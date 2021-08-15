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
 * @date 2021/6/24 5:50 下午
 */
class Q149Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,1},{2,2},{3,3}}, 3),
                    Arguments.of(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}, 4),
                    Arguments.of(new int[][]{{1,1},{-1,-1},{1,-1},{-1,1},{0,0}}, 3),
                    Arguments.of(new int[][]{{2,3},{3,3},{-5,3}}, 3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxPoints(int[][] points, int result) {
        Assertions.assertEquals(result, new Q149().maxPoints(points));
    }
}