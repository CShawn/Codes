package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/9/16 5:13 下午
 */
class Q212Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},
                            new String[]{"ABCCED","SEE","ABCB","BFCEDASA"}, new String[]{"ABCCED","BFCEDASA","SEE"}),
                    Arguments.arguments(new char[][]{{'A'}}, new String[]{"A"}, new String[]{"A"}),
                    Arguments.arguments(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                            new String[]{"oath","pea","eat","rain"}, new String[]{"eat","oath"}),
                    Arguments.arguments(new char[][]{{'a','b'},{'c','d'}}, new String[]{"abcb"}, new String[0])
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void findWords(char[][] board, String[] words, String[] result) {
        Object[] res = new Q212().findWords(board, words).toArray();
        Arrays.sort(res);
        assertArrayEquals(result, res);
    }
}