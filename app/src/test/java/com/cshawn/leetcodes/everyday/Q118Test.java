package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/2/12 12:53 下午
 */
class Q118Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{new int[]{1}}, 1),
                    Arguments.of(new int[][]{new int[]{1},new int[]{1,1}}, 2),
                    Arguments.of(new int[][]{new int[]{1},new int[]{1,1},new int[]{1,2,1}}, 3),
                    Arguments.of(new int[][]{new int[]{1},new int[]{1,1},new int[]{1,2,1},new int[]{1,3,3,1}}, 4),
                    Arguments.of(new int[][]{new int[]{1},new int[]{1,1},new int[]{1,2,1},new int[]{1,3,3,1},new int[]{1,4,6,4,1}}, 5),
                    Arguments.of(new int[][]{new int[]{1},new int[]{1,1},new int[]{1,2,1},
                            new int[]{1,3,3,1},new int[]{1,4,6,4,1},new int[]{1,5,10,10,5,1}}, 6),
                    Arguments.of(new int[][]{new int[]{1},new int[]{1,1},new int[]{1,2,1},
                            new int[]{1,3,3,1},new int[]{1,4,6,4,1},new int[]{1,5,10,10,5,1},new int[]{1,6,15,20,15,6,1}}, 7),
                    Arguments.of(new int[][]{new int[]{1},new int[]{1,1},new int[]{1,2,1},
                            new int[]{1,3,3,1},new int[]{1,4,6,4,1},new int[]{1,5,10,10,5,1},new int[]{1,6,15,20,15,6,1},new int[]{1,7,21,35,35,21,7,1}}, 8)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void generate(int[][] result, int numRows) {
        List<List<Integer>> list = new Q118().generate(numRows);
        int[][] a = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            a[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                a[i][j] = list.get(i).get(j);
            }
        }
        Assertions.assertArrayEquals(result, a);
    }
}