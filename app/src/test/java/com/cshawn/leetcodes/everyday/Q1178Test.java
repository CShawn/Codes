package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/2/26 5:36 下午
 */
class Q1178Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"a"}, new String[]{"b"}, new Integer[]{0}),
                    Arguments.of(new String[]{"a"}, new String[]{"b", "c"}, new Integer[]{0, 0}),
                    Arguments.of(new String[]{"a", "b"}, new String[]{"c"}, new Integer[]{0}),
                    Arguments.of(new String[]{"a", "b"}, new String[]{"c", "d"}, new Integer[]{0, 0}),
                    Arguments.of(new String[]{"a", "b"}, new String[]{"bc", "bd", "ba", "ab"}, new Integer[]{1, 1, 1, 1}),
                    Arguments.of(new String[]{"ab", "bcd"}, new String[]{"bac", "dcab"}, new Integer[]{1, 1}),
                    Arguments.of(new String[]{"ab", "bc"}, new String[]{"bac", "dcab"}, new Integer[]{2, 0}),
                    Arguments.of(new String[]{"aaaa","asas","able","ability","actt","actor","access"},
                            new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}, new Integer[]{1,1,3,2,4,0}),
                    Arguments.of(new String[]{"apple","pleas","please"},
                            new String[]{"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"}, new Integer[]{0,1,3,2,0})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findNumOfValidWords1(String[] words, String[] puzzles, Integer[] result) {
        Assertions.assertArrayEquals(result, new Q1178().findNumOfValidWords1(words, puzzles).toArray());
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findNumOfValidWords(String[] words, String[] puzzles, Integer[] result) {
        Assertions.assertArrayEquals(result, new Q1178().findNumOfValidWords(words, puzzles).toArray());
    }
}