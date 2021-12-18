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
 * @date 2021/12/18 1:26 下午
 */
class Q419Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}, 2),
                    Arguments.of(new char[][]{{'.'}}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void countBattleships(char[][] board, int result) {
        assertEquals(result, new Q419().countBattleships1(board));
        assertEquals(result, new Q419().countBattleships(board));
    }
}