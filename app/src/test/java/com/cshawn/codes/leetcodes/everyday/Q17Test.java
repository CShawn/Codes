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
 * @date 2021/7/21 5:11 下午
 */
class Q17Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("", new String[0]),
                    Arguments.of(null, new String[0]),
                    Arguments.of("23", new String[]{"ad","ae","af","bd","be","bf","cd","ce","cf"}),
                    Arguments.of("2", new String[]{"a","b","c"})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void letterCombinations(String digits, String[] result) {
        Assertions.assertArrayEquals(result, new Q17().letterCombinations(digits).toArray());
    }
}