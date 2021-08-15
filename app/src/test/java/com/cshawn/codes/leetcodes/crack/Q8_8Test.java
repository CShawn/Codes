package com.cshawn.codes.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/3/30 8:54 下午
 */
class Q8_8Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments("a", new String[]{"a"}),
                    Arguments.arguments("ab", new String[]{"ab", "ba"}),
                    Arguments.arguments("abc", new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}),
                    Arguments.arguments("aba", new String[]{"aab", "aba", "baa"}),
                    Arguments.arguments("aab", new String[]{"aab", "aba", "baa"}),
                    Arguments.arguments("baa", new String[]{"aab", "aba", "baa"}),
                    Arguments.arguments("aAb", new String[]{"Aab", "Aba", "aAb", "abA", "bAa", "baA"})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void permutation(String s, String[] result) {
        String[] res = new Q8_8().permutation(s);
        Arrays.sort(res);
        Assertions.assertArrayEquals(result, res);
    }
}