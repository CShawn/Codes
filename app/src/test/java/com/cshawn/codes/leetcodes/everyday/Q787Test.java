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
 * @date 2021/8/24 10:56 上午
 */
class Q787Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1, 200),
                    Arguments.of(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0, 500),
                    Arguments.of(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 2, 1, 3, -1),
                    Arguments.of(3, new int[][]{{0,1,100},{1,2,100},{0,2,200}}, 0, 2, 1, 200),
                    Arguments.of(2, new int[][]{{0,1,100},{1,0,100}}, 0, 1, 2, 100)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findCheapestPrice(int n, int[][] flights, int src, int dst, int k, int result) {
        Assertions.assertEquals(result, new Q787().findCheapestPrice1(n, flights, src, dst, k));
        Assertions.assertEquals(result, new Q787().findCheapestPrice2(n, flights, src, dst, k));
        Assertions.assertEquals(result, new Q787().findCheapestPrice3(n, flights, src, dst, k));
        Assertions.assertEquals(result, new Q787().findCheapestPrice(n, flights, src, dst, k));
    }
}