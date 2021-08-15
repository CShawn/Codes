package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author C.Shawn
 * @date 2021/3/3 5:00 下午
 */
class Q338Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(0, new int[]{0}),
                    Arguments.arguments(1, new int[]{0, 1}),
                    Arguments.arguments(2, new int[]{0, 1, 1}),
                    Arguments.arguments(3, new int[]{0, 1, 1, 2}),
                    Arguments.arguments(4, new int[]{0, 1, 1, 2, 1}),
                    Arguments.arguments(5, new int[]{0, 1, 1, 2, 1, 2}),
                    Arguments.arguments(6, new int[]{0, 1, 1, 2, 1, 2, 2}),
                    Arguments.arguments(7, new int[]{0, 1, 1, 2, 1, 2, 2, 3}),
                    Arguments.arguments(8, new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1}),
                    Arguments.arguments(9, new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2})
            );
        }
    }
    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void countBits(int num, int[] result) {
        assertArrayEquals(result, new Q338().countBits1(num));
        assertArrayEquals(result, new Q338().countBits2(num));
        assertArrayEquals(result, new Q338().countBits(num));
    }
}