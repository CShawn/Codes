package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/3/7 8:59 下午
 */
class Q131Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("a", new String[][]{new String[]{"a"}}),
                    Arguments.of("aa", new String[][]{new String[]{"a", "a"}, new String[]{"aa"}}),
                    Arguments.of("aab", new String[][]{new String[]{"a", "a", "b"}, new String[]{"aa", "b"}}),
                    Arguments.of("aabb", new String[][]{new String[]{"a", "a", "b", "b"}, new String[]{"a", "a", "bb"}, new String[]{"aa", "b", "b"}, new String[]{"aa", "bb"}}),
                    Arguments.of("abbab", new String[][]{new String[]{"a", "b", "b", "a", "b"}, new String[]{"a", "b", "bab"}, new String[]{"a", "bb", "a", "b"}, new String[]{"abba", "b"}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void partition1(String s, String[][] result) {
        List<List<String>> res = new Q131().partition1(s);
        assertEquals(result.length, res.size());
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i].length, res.get(i).size());
            for (int j = 0; j < result[i].length; j++) {
                assertEquals(res.get(i).get(j), result[i][j]);
            }
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void partition(String s, String[][] result) {
        List<List<String>> res = new Q131().partition(s);
        assertEquals(result.length, res.size());
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i].length, res.get(i).size());
            for (int j = 0; j < result[i].length; j++) {
                assertEquals(res.get(i).get(j), result[i][j]);
            }
        }
    }
}