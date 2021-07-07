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
 * @date 2021/7/7 9:38 上午
 */
class Q1711Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,3,5,7,9}, 4),
                    Arguments.of(new int[]{0,1,1,1}, 6),
                    Arguments.of(new int[]{1,1,1,3,3,3,7}, 15),
                    Arguments.of(new int[]{0,0,2,16}, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void countPairs(int[] deliciousness, int result) {
        Assertions.assertEquals(result, new Q1711().countPairs1(deliciousness));
        Assertions.assertEquals(result, new Q1711().countPairs(deliciousness));
    }
}