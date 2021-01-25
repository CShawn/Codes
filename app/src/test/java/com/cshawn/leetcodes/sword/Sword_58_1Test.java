package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/25 1:35 下午
 */
class Sword_58_1Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, null),
                    Arguments.of("", ""),
                    Arguments.of(" ", ""),
                    Arguments.of("      ", ""),
                    Arguments.of("   a  ", "a"),
                    Arguments.of("a b", "b a"),
                    Arguments.of(" a  b   ", "b a"),
                    Arguments.of("   a  b  c  ", "c b a"),
                    Arguments.of("a  b  c  ", "c b a")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void reverseWords(String origin, String result) {
        Assertions.assertEquals(result, new Sword_58_1().reverseWords(origin));
    }
}