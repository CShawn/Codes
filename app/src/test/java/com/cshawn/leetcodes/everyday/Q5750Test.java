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
 * @date 2021/5/9 10:42 上午
 */
class Q5750Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1993,1999},{2000,2010}}, 1993),
                    Arguments.of(new int[][]{{1950,1961},{1960,1971},{1970,1981}}, 1960),
                    Arguments.of(new int[][]{{1982,1998},{2013,2042},{2010,2035},{2022,2050},{2047,2048}}, 2022)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maximumPopulation(int[][] logs, int result) {
        Assertions.assertEquals(result, new Q5750().maximumPopulation1(logs));
        Assertions.assertEquals(result, new Q5750().maximumPopulation(logs));
    }
}