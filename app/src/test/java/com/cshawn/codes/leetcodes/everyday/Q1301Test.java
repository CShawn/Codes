package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/8/23 11:10 上午
 */
class Q1301Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"E23","2X2","12S"}, new int[]{7,1}),
                    Arguments.of(new String[]{"E12","1X1","21S"}, new int[]{4,2}),
                    Arguments.of(new String[]{"E11","XXX","11S"}, new int[]{0,0}),
                    Arguments.of(new String[]{"EX","XS"}, new int[]{0,1}),
                    Arguments.of(new String[]{"E11345","X452XX","3X43X4","44X312","23452X","1342XS"}, new int[]{27,1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void pathsWithMaxScore(String[] board, int[] result) {
        Assertions.assertArrayEquals(result, new Q1301().pathsWithMaxScore1(Arrays.asList(board)));
        Assertions.assertArrayEquals(result, new Q1301().pathsWithMaxScore(Arrays.asList(board)));
    }
}