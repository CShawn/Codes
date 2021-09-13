package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/9/13 11:25 上午
 */
class Q447Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{0,0},{1,0},{2,0}}, 2),
                    Arguments.of(new int[][]{{0,0},{1,0},{0,1}}, 2),
                    Arguments.of(new int[][]{{1,1},{2,2},{3,3}}, 2),
                    Arguments.of(new int[][]{{1,1}}, 0),
                    Arguments.of(new int[][]{{1,1}, {2,2}, {4,4}}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void numberOfBoomerangs(int[][] points, int result) {
        assertEquals(result, new Q447().numberOfBoomerangs1(points));
        assertEquals(result, new Q447().numberOfBoomerangs(points));
    }
}