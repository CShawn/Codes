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
 * @date 2021/10/21 8:12 上午
 */
class Q66Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3}, new int[]{1,2,4}),
                    Arguments.of(new int[]{4,3,2,1}, new int[]{4,3,2,2}),
                    Arguments.of(new int[]{9}, new int[]{1,0}),
                    Arguments.of(new int[]{0}, new int[]{1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void plusOne1(int[] digits, int[] result) {
        assertArrayEquals(result, new Q66().plusOne1(digits));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void plusOne(int[] digits, int[] result) {
        assertArrayEquals(result, new Q66().plusOne(digits));
    }
}