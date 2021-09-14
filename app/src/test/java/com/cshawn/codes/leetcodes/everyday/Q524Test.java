package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/9/14 8:49 上午
 */
class Q524Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("abpcplea", new String[]{"ale","apple","monkey","plea"}, "apple"),
                    Arguments.of("abpcplea", new String[]{"b","a","c"}, "a"),
                    Arguments.of("abpcplea", new String[]{"apz","by","ca"}, "ca"),
                    Arguments.of("abpcplea", new String[]{"x","y","z"}, "")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findLongestWord(String s, String[] dictionary, String result) {
        assertEquals(result, new Q524().findLongestWord1(s, Arrays.asList(dictionary)));
        assertEquals(result, new Q524().findLongestWord2(s, Arrays.asList(dictionary)));
        assertEquals(result, new Q524().findLongestWord(s, Arrays.asList(dictionary)));
    }
}