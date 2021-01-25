package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/1/25 6:43 下午
 */
class Sword_58_2Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, 0, null),
                    Arguments.of("", 0, ""),
                    Arguments.of("ab", 1, "ba"),
                    Arguments.of("abc", 1, "bca"),
                    Arguments.of("abc", 2, "cab")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void reverseLeftWords1(String s, int n, String result) {
        Assertions.assertEquals(result, new Sword_58_2().reverseLeftWords1(s, n));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void reverseLeftWords2(String s, int n, String result) {
        Assertions.assertEquals(result, new Sword_58_2().reverseLeftWords2(s, n));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void reverseLeftWords3(String s, int n, String result) {
        Assertions.assertEquals(result, new Sword_58_2().reverseLeftWords3(s, n));
    }
}