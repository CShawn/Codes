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
 * @date 2021/3/8 8:40 下午
 */
class Q132Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("a", 0),
                    Arguments.of("aa", 0),
                    Arguments.of("aab", 1),
                    Arguments.of("abc", 2),
                    Arguments.of("aabb", 1),
                    Arguments.of("abbab", 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minCut(String s, int result) {
        Assertions.assertEquals(result, new Q132().minCut(s));
    }
}