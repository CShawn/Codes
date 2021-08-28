package com.cshawn.codes.acwing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/8/28 12:30 下午
 */
class Q2Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(4, 5, new int[]{1,2,3,4}, new int[]{2,4,4,5}, 8),
                    Arguments.of(3, 4, new int[]{4,2,3}, new int[]{4,2,3}, 4),
                    Arguments.of(3, 5, new int[]{4,2,3}, new int[]{4,2,3}, 5)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void pack01(int N, int V, int[] v, int[] w, int result) {
        Assertions.assertEquals(result, new Q2().pack01_1(N, V, v, w));
        Assertions.assertEquals(result, new Q2().pack01_2(N, V, v, w));
        Assertions.assertEquals(result, new Q2().pack01(N, V, v, w));
    }
}