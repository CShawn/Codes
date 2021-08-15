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
 * @date 2021/1/26 2:56 下午
 */
class Sword_60Test {

    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(1, new double[]{1 / 6.0, 1 / 6.0, 1 / 6.0, 1 / 6.0, 1 / 6.0, 1 / 6.0}),
                    Arguments.of(2, new double[]{1 / 36.0, 1 / 18.0, 1 / 12.0, 1 / 9.0, 5 / 36.0, 1 / 6.0, 5 / 36.0, 1 / 9.0, 1 / 12.0, 1 / 18.0, 1 / 36.0})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void dicesProbability(int n, double[] probability) {
        double[] actual = new Sword_60().dicesProbability(n);
        Assertions.assertEquals(actual.length, probability.length);
        for (int i = 0; i < actual.length; i++) {
            Assertions.assertTrue(Math.abs(probability[i] - actual[i]) < 1e-6);
        }
    }
}