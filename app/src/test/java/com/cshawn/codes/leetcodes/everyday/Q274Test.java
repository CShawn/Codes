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
 * @date 2021/7/11 11:23 上午
 */
class Q274Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,0,6,1,5}, 3),
                    Arguments.of(new int[]{0,1,3,3,4,5,5,6}, 4),
                    Arguments.of(new int[]{0,1,2,3}, 2),
                    Arguments.of(new int[]{5,5,5}, 3),
                    Arguments.of(new int[]{0,0,0}, 0),
                    Arguments.of(new int[]{1,1,1}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void hIndex(int[] citations, int result) {
        Assertions.assertEquals(result, new Q274().hIndex1(citations));
        Assertions.assertEquals(result, new Q274().hIndex(citations));
    }
}