package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/12/26 1:21 下午
 */
class Q1078Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("alice is a good girl she is a good student", "a", "good", new String[]{"girl","student"}),
                    Arguments.of("we will we will rock you", "we","will", new String[]{"we","rock"}),
                    Arguments.of("a a a a a a", "a","a", new String[]{"a","a","a","a"}),
                    Arguments.of("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa",
                            "kcyxdfnoa","jkypmsxd", new String[]{"kcyxdfnoa","kcyxdfnoa","kcyxdfnoa"})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findOcurrences(String text, String first, String second, String[] result) {
        assertArrayEquals(result, new Q1078().findOcurrences1(text, first, second));
        assertArrayEquals(result, new Q1078().findOcurrences(text, first, second));
    }
}