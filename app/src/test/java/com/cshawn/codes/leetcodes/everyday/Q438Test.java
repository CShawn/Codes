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
 * @date 2021/11/28 12:17 下午
 */
class Q438Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("cbaebabacd", "abc", new Integer[]{0, 6}),
                    Arguments.of("abab", "ab", new Integer[]{0, 1, 2}),
                    Arguments.of("ada", "a", new Integer[]{0, 2})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findAnagrams(String s, String p, Integer[] result) {
        assertArrayEquals(result, new Q438().findAnagrams(s, p).toArray());
    }
}