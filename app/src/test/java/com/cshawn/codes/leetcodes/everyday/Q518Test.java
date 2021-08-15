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
 * @date 2021/3/6 11:22 上午
 */
public class Q518Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(5, new int[]{1, 2, 5}, 4),
                    Arguments.of(3, new int[]{2}, 0),
                    Arguments.of(10, new int[]{10}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void change(int amount, int[] coins, int result) {
        Assertions.assertEquals(result, new Q518().change(amount, coins));
    }
}
