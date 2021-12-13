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
 * @date 2021/12/13 8:34 上午
 */
class Q807Test {
    static class DataArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(Arguments.of(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}, 35));
        }
    }
    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxIncreaseKeepingSkyline(int[][] grid, int result) {
        assertEquals(result, new Q807().maxIncreaseKeepingSkyline(grid));
    }
}