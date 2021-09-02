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
 * @date 2021/9/1 7:24 下午
 */
class Q3Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(4, 5, new int[]{1,2,3,4}, new int[]{2,4,4,5}, 10),
                    Arguments.of(2, 5, new int[]{1,2}, new int[]{1,2}, 5),
                    Arguments.of(20, 200, new int[]{24, 42, 20, 7, 48, 4, 3, 7, 52, 50, 5, 9, 14, 9, 55, 40, 35, 33, 12, 65},
                            new int[]{ 50, 60, 49, 15, 115, 11, 8, 5, 66, 25, 8, 25, 40, 22, 42, 30, 49, 16, 12, 127}, 571)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxValue(int N, int V, int[] v, int[] w, int result) {
        Assertions.assertEquals(result, new Q3().maxValue1(N, V, v, w));
        Assertions.assertEquals(result, new Q3().maxValue2(N, V, v, w));
        Assertions.assertEquals(result, new Q3().maxValue3(N, V, v, w));
        Assertions.assertEquals(result, new Q3().maxValue(N, V, v, w));
    }
}