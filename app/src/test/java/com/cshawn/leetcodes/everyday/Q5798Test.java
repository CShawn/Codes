package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class Q5798Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{40,10},{30,20}}, 1, new int[][]{{10,20},{40,30}}),
                    Arguments.of(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, 2, new int[][]{{3,4,8,12},{2,11,10,16},{1,7,6,15},{5,9,13,14}}),
                    Arguments.of(new int[][]{{10,1,4,8},{6,6,3,10},{7,4,7,10},{1,10,6,1},{2,1,1,10},{3,8,9,2},{7,1,10,10},{7,1,4,9},{2,2,4,2},{10,7,5,10}}, 1,
                    new int[][]{{1,4,8,10},{10,3,7,10},{6,6,6,1},{7,4,1,10},{1,10,9,2},{2,1,10,10},{3,8,4,9},{7,1,4,2},{7,1,2,10},{2,10,7,5}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void rotateGrid(int[][] grid, int k, int[][] result) {
        Assertions.assertArrayEquals(result, new Q5798().rotateGrid(grid, k));
    }
}
