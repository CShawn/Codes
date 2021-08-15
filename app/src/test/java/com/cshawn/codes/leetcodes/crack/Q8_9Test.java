package com.cshawn.codes.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/3/30 9:20 下午
 */
class Q8_9Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(0, new String[]{""}),
                    Arguments.arguments(1, new String[]{"()"}),
                    Arguments.arguments(2, new String[]{"(())", "()()"}),
                    Arguments.arguments(3, new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void generateParenthesis(int n, String[] result) {
        String[] res = new Q8_9().generateParenthesis(n).toArray(new String[0]);
        Arrays.sort(res);
        Assertions.assertArrayEquals(result, res);
    }
}