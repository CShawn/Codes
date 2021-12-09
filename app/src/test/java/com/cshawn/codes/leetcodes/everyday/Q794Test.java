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
 * @date 2021/12/9 9:12 上午
 */
class Q794Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"O  ", "   ", "   "}, false),
                    Arguments.of(new String[]{"XOX", " X ", "   "}, false),
                    Arguments.of(new String[]{"XXX", "   ", "OOO"}, false),
                    Arguments.of(new String[]{"XOX", "O O", "XOX"}, true),
                    Arguments.of(new String[]{"XOX", "XXO", "OOX"}, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void validTicTacToe(String[] board, boolean result) {
        assertEquals(result, new Q794().validTicTacToe(board));
    }
}