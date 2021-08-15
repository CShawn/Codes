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
 * @date 2021/6/14 2:08 下午
 */
class Q63Test {
    
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[][]{{0,0},{1,0}}, 1),
                    Arguments.arguments(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void uniquePathsWithObstacles(int[][] obstacleGrid, int result) {
        Assertions.assertEquals(result, new Q63().uniquePathsWithObstacles1(obstacleGrid));
        Assertions.assertEquals(result, new Q63().uniquePathsWithObstacles(obstacleGrid));
    }
}