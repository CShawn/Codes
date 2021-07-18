package com.cshawn.leetcodes.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/7/18 11:18 上午
 */
class Q10_2Test {
    static class DataArgumentsProvider1 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                            new String[][]{{"tan", "nat"}, {"bat"}, {"eat", "tea", "ate"}}),
                    Arguments.of(new String[0], new String[0][0]),
                    Arguments.of(new String[]{"a"}, new String[][]{{"a"}})
            );
        }
    }

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                            new String[][]{{"eat", "tea", "ate"}, {"tan", "nat"}, {"bat"}}),
                    Arguments.of(new String[0], new String[0][0]),
                    Arguments.of(new String[]{"a"}, new String[][]{{"a"}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider1.class)
    void groupAnagrams1(String[] strs, String[][] result) {
        List<List<String>> lists = new Q10_2().groupAnagrams1(strs);
        String[][] res = new String[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            res[i] = lists.get(i).toArray(new String[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void groupAnagrams(String[] strs, String[][] result) {
        List<List<String>> lists = new Q10_2().groupAnagrams(strs);
        String[][] res = new String[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            res[i] = lists.get(i).toArray(new String[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }
}