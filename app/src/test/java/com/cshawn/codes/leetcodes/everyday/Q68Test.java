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
 * @date 2021/9/9 8:44 上午
 */
class Q68Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"This"}, 6, new String[]{"This  "}),
                    Arguments.of(new String[]{"This","is"}, 6, new String[]{"This  ", "is    "}),
                    Arguments.of(new String[]{"This","is"}, 9, new String[]{"This is  "}),
                    Arguments.of(new String[]{"This","is", "a"}, 9, new String[]{"This is a"}),
                    Arguments.of(new String[]{"This","is", "a"}, 8, new String[]{"This  is","a       "}),
                    Arguments.of(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16,
                            new String[]{"This    is    an","example  of text","justification.  "}),
                    Arguments.of(new String[]{"What","must","be","acknowledgment","shall","be"}, 16,
                            new String[]{"What   must   be","acknowledgment  ","shall be        "}),
                    Arguments.of(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                                    "to","a","computer.","Art","is","everything","else","we","do"}, 20,
                            new String[]{"Science  is  what we","understand      well", "enough to explain to",
                                    "a  computer.  Art is", "everything  else  we", "do                  "})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void fullJustify(String[] words, int maxWidth, String[] result) {
        Assertions.assertArrayEquals(result, new Q68().fullJustify(words, maxWidth).toArray());
    }
}