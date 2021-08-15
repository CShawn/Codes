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
 * @date 2021/3/20 10:43 上午
 */
class Q150Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new String[]{"2","1","+","3","*"}, 9),
                    Arguments.arguments(new String[]{"4","13","5","/","+"}, 6),
                    Arguments.arguments(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}, 22)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void evalRPN(String[] tokens, int result) {
        Assertions.assertEquals(result, new Q150().evalRPN1(tokens));
        Assertions.assertEquals(result, new Q150().evalRPN2(tokens));
        Assertions.assertEquals(result, new Q150().evalRPN3(tokens));
        Assertions.assertEquals(result, new Q150().evalRPN(tokens));
    }
}