package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/6/10 21:52
 */
public class Q322Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1, 2, 5}, 11, 3),
                    Arguments.of(new int[]{2}, 3, -1),
                    Arguments.of(new int[]{1}, 0, 0),
                    Arguments.of(new int[]{1}, 1, 1),
                    Arguments.of(new int[]{1}, 2, 2),
                    Arguments.of(new int[]{2,3}, 7, 3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void coinChange(int[] coins, int amount, int result) {
        Assertions.assertEqulas(result, new Q322().coinChange(coins, amount));
    }
}
