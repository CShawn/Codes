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
 * @date 2021/6/1 9:33 下午
 */
class Q1744Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{7,4,5,3,8},
                            new int[][]{{0,2,2},{4,2,4},{2,13,1000000000}},
                            new boolean[]{true,false,true}),
                    Arguments.of(new int[]{5,2,6,4,1},
                            new int[][]{{3,1,2},{4,10,3},{3,10,100},{4,100,30},{1,3,1}},
                            new boolean[]{false,true,true,false,false}),
                    Arguments.of(new int[]{46,5,47,48,43,34,15,26,11,25,41,47,15,25,16,50,32,42,32,21,36,34,50,45,46,15,46,38,50,12,3,26,26,16,23,1,4,48,47,32,47,16,33,23,38,2,19,50,6,19,29,3,27,12,6,22,33,28,7,10,12,8,13,24,21,38,43,26,35,18,34,3,14,48,50,34,38,4,50,26,5,35,11,2,35,9,11,31,36,20,21,37,18,34,34,10,21,8,5},
                            new int[][]{{13,1972,27},{11,387,2},{85,54,42}},
                            new boolean[]{false, true, true})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void canEat(int[] candiesCount, int[][] queries, boolean[] result) {
        Assertions.assertArrayEquals(result, new Q1744().canEat1(candiesCount, queries));
        Assertions.assertArrayEquals(result, new Q1744().canEat2(candiesCount, queries));
        Assertions.assertArrayEquals(result, new Q1744().canEat(candiesCount, queries));
    }
}