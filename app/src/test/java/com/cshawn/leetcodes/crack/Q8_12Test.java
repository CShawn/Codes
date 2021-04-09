package com.cshawn.leetcodes.crack;

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
 * @date 2021/4/8 2:33 下午
 */
class Q8_12Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(0, new String[0][0]),
                    Arguments.arguments(1, new String[][]{{"Q"}}),
                    Arguments.arguments(2, new String[0][0]),
                    Arguments.arguments(3, new String[0][0]),
                    Arguments.arguments(4, new String[][]{
                            {".Q..","...Q","Q...","..Q."},
                            {"..Q.","Q...","...Q",".Q.."}
                    })
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void solveNQueens(int n, String[][] result) {
        List<List<String>> res = new Q8_12().solveNQueens(n);
        String[][] convert = new String[res.size()][n];
        for (int i = 0; i < res.size(); i++) {
            convert[i] = res.get(i).toArray(new String[0]);
        }
        Assertions.assertArrayEquals(result, convert);
    }
}