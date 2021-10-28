package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.Arrays;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author C.Shawn
 * @date 2021/10/27 6:15 下午
 */
class Q301Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("()())()", new String[]{"(())()","()()()"}),
                    Arguments.of("(a)())()", new String[]{"(a())()","(a)()()"}),
                    Arguments.of(")(", new String[]{""}),
                    Arguments.of("(((k()((", new String[]{"k()","(k)"}),
                    Arguments.of("(r(()()(", new String[]{"r()()","r(())","(r)()","(r())"})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeInvalidParentheses(String s, String[] result) {
        Arrays.sort(result);
        Object[] res1 = new Q301().removeInvalidParentheses1(s).toArray();
        Arrays.sort(res1);
        assertArrayEquals(result, res1);
        Object[] res = new Q301().removeInvalidParentheses(s).toArray();
        Arrays.sort(res);
        assertArrayEquals(result, res);
    }
}