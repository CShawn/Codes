package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author C.Shawn
 * @date 2021/10/13 10:01 上午
 */
class Q412Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(
                            15,
                            new String[]{
                                    "1",
                                    "2",
                                    "Fizz",
                                    "4",
                                    "Buzz",
                                    "Fizz",
                                    "7",
                                    "8",
                                    "Fizz",
                                    "Buzz",
                                    "11",
                                    "Fizz",
                                    "13",
                                    "14",
                                    "FizzBuzz"
                            })
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void fizzBuzz(int n, String[] result) {
        assertArrayEquals(result, new Q412().fizzBuzz(n).toArray());
    }
}