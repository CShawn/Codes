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
 * @date 2021/3/29 5:46 下午
 */
class Q190Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(0b00000010100101000001111010011100, 0b00111001011110000010100101000000),
                    Arguments.arguments(0b11111111111111111111111111111101, 0b10111111111111111111111111111111)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void reverseBits1(int n, int result) {
        Assertions.assertEquals(result, new Q190().reverseBits1(n));
        Assertions.assertEquals(result, new Q190().reverseBits(n));
    }
}