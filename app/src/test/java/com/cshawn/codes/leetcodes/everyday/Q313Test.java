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
 * @date 2021/8/9 4:14 下午
 */
class Q313Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(12, new int[]{2,7,13,19}, 32),
                    Arguments.of(1, new int[]{2,3,5}, 1),
                    Arguments.of(15, new int[]{2,3,5}, 24)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void nthSuperUglyNumber(int n, int[] primes, int result) {
        Assertions.assertEquals(result, new Q313().nthSuperUglyNumber(n, primes));
    }
}