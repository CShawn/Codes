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
 * @date 2021/9/16 4:53 下午
 */
class Q79Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED", true),
                    Arguments.arguments(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE", true),
                    Arguments.arguments(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB", false),
                    Arguments.arguments(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "BFCEDASA", true),
                    Arguments.arguments(new char[][]{{'A'}}, "A", true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void exist(char[][] board, String word, boolean result) {
        assertEquals(result, new Q79().exist1(board, word));
        assertEquals(result, new Q79().exist(board, word));
    }
}