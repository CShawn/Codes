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
 * @date 2021/5/11 5:21 下午
 */
class Q1734Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,1}, new int[]{1,2,3}),
                    Arguments.of(new int[]{6,5,4,6}, new int[]{2,4,1,5,3})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void decode(int[] encoded, int[] result) {
        Assertions.assertArrayEquals(result, new Q1734().decode1(encoded));
        Assertions.assertArrayEquals(result, new Q1734().decode(encoded));
    }
}