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
 * @date 2021/6/16 6:11 下午
 */
class Q877Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{5,3,4,5}, true),
                    Arguments.of(new int[]{1,3,1,2}, true),
                    Arguments.of(new int[]{2,3}, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void stoneGame(int[] piles, boolean result) {
        Assertions.assertEquals(result, new Q877().stoneGame1(piles));
        Assertions.assertEquals(result, new Q877().stoneGame2(piles));
        Assertions.assertEquals(result, new Q877().stoneGame3(piles));
        Assertions.assertEquals(result, new Q877().stoneGame(piles));
    }
}