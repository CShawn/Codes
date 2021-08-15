package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/6 10:47 下午
 */
class Sword_38Test {
    private final Sword_38 test = new Sword_38();

    static class StringArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, new String[0]),
                    Arguments.of("1", new String[]{"1"}),
                    Arguments.of("12", new String[]{"12", "21"}),
                    Arguments.of("123", new String[]{
                            "132", "231", "123", "321", "213", "312"
                    }),
                    Arguments.of("113", new String[]{
                            "113", "311", "131"
                    })
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(StringArgumentsProvider.class)
    void permutation(String str, String[] expected) {
        assertArrayEquals(expected, test.permutation(str));
    }
}