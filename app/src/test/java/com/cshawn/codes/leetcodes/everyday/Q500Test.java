package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author C.Shawn
 * @date 2021/10/31 11:06 上午
 */
class Q500Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"Hello","Alaska","Dad","Peace"}, new String[]{"Alaska","Dad"}),
                    Arguments.of(new String[]{"omk"}, new String[0]),
                    Arguments.of(new String[]{"adsdf","sfd"}, new String[]{"adsdf","sfd"})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findWords(String[] words, String[] result) {
        assertArrayEquals(result, new Q500().findWords1(words));
        assertArrayEquals(result, new Q500().findWords(words));
    }
}