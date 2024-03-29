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
 * @date 2021/7/2 11:09 上午
 */
class Q1833Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,3,2,4,1}, 7, 4),
                    Arguments.of(new int[]{10,6,8,7,7,8}, 5, 0),
                    Arguments.of(new int[]{1,6,3,1,2,5},20,6)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxIceCream(int[] costs, int coins, int result) {
        Assertions.assertEquals(result, new Q1833().maxIceCream(costs, coins));
    }
}