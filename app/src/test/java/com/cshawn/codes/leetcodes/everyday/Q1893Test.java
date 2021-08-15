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
 * @date 2021/7/23 7:10 下午
 */
class Q1893Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,2},{3,4},{5,6}}, 2, 5, true),
                    Arguments.of(new int[][]{{1,10},{10,20}}, 21, 21, false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isCovered(int[][] ranges, int left, int right, boolean result) {
        Assertions.assertEquals(result, new Q1893().isCovered1(ranges, left, right));
        Assertions.assertEquals(result, new Q1893().isCovered2(ranges, left, right));
        Assertions.assertEquals(result, new Q1893().isCovered3(ranges, left, right));
        Assertions.assertEquals(result, new Q1893().isCovered(ranges, left, right));
    }
}