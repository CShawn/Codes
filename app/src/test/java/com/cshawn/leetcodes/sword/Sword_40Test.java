package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/8 9:09 下午
 */
class Sword_40Test {
    private final Sword_40 test = new Sword_40();

    static class ArrayArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 9, new int[0]),
                    Arguments.of(new int[]{1,2,3}, 0, new int[0]),
                    Arguments.of(new int[]{1,2,3}, 4, new int[]{1,2,3}),
                    Arguments.of(new int[]{3,2,1}, 1, new int[]{1}),
                    Arguments.of(new int[]{1,1,1}, 1, new int[]{1}),
                    Arguments.of(new int[]{3,2,1}, 2, new int[]{2,1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ArrayArgumentsProvider.class)
    void getLeastNumbers(int[] array, int k, int[] result) {
        assertArrayEquals(result, test.getLeastNumbers(array, k));
    }
}