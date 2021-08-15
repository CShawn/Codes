package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/1/27 8:29 下午
 */
class Sword_63Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 0),
                    Arguments.of(new int[]{7,1,5,3,6,4}, 5),
                    Arguments.of(new int[]{7,6,4,3,1}, 0),
                    Arguments.of(new int[]{1,1,1,1,1}, 0),
                    Arguments.of(new int[]{4,9,0,2,1}, 5),
                    Arguments.of(new int[]{3,6,2,2,6}, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxProfit(int[] array, int profit) {
        Assertions.assertEquals(profit, new Sword_63().maxProfit(array));
    }
}