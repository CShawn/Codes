package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/9/17 3:59 下午
 */
class Q36Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new char[][]{
                            {'5','3','.','.','7','.','.','.','.' },
                            {'6','.','.','1','9','5','.','.','.' },
                            {'.','9','8','.','.','.','.','6','.' },
                            {'8','.','.','.','6','.','.','.','3' },
                            {'4','.','.','8','.','3','.','.','1' },
                            {'7','.','.','.','2','.','.','.','6' },
                            {'.','6','.','.','.','.','2','8','.' },
                            {'.','.','.','4','1','9','.','.','5' },
                            {'.','.','.','.','8','.','.','7','9'}}, true),
                    Arguments.of(new char[][]{
                            {'8','3','.','.','7','.','.','.','.' },
                            {'6','.','.','1','9','5','.','.','.' },
                            {'.','9','8','.','.','.','.','6','.' },
                            {'8','.','.','.','6','.','.','.','3' },
                            {'4','.','.','8','.','3','.','.','1' },
                            {'7','.','.','.','2','.','.','.','6' },
                            {'.','6','.','.','.','.','2','8','.' },
                            {'.','.','.','4','1','9','.','.','5' },
                            {'.','.','.','.','8','.','.','7','9'}}, false),
                    Arguments.of(new char[][]{
                            {'.','8','7','6','5','4','3','2','1' },
                            {'2','.','.','.','.','.','.','.','.' },
                            {'3','.','.','.','.','.','.','.','.' },
                            {'4','.','.','.','.','.','.','.','.' },
                            {'5','.','.','.','.','.','.','.','.' },
                            {'6','.','.','.','.','.','.','.','.' },
                            {'7','.','.','.','.','.','.','.','.' },
                            {'8','.','.','.','.','.','.','.','.' },
                            {'9','.','.','.','.','.','.','.','.'}}, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isValidSudoku(char[][] board, boolean result) {
        assertEquals(result, new Q36().isValidSudoku(board));
    }
}