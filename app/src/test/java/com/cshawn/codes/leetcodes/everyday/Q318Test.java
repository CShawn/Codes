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
 * @date 2021/11/17 10:18 上午
 */
class Q318Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}, 16),
                    Arguments.of(new String[]{"a","ab","abc","d","cd","bcd","abcd"}, 4),
                    Arguments.of(new String[]{"a","aa","aaa","aaaa"}, 0),
                    Arguments.of(new String[]{"a","aa","aaaa","aaa","bb"}, 8)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxProduct(String[] words, int result) {
        assertEquals(result, new Q318().maxProduct(words));
        assertEquals(result, new Q318().maxProduct1(words));
    }
}