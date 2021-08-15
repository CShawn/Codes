package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/1/28 10:29 上午
 */
class Sword_66Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], new int[0]),
                    Arguments.of(new int[]{1,2}, new int[]{2,1}),
                    Arguments.of(new int[]{1,2,3,4,5}, new int[]{120,60,40,30,24}),
                    Arguments.of(new int[]{7,6,4,3,1}, new int[]{72,84,126,168,504}),
                    Arguments.of(new int[]{1,1,1,1,1}, new int[]{1,1,1,1,1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void constructArr(int[] a, int[] b) {
        Assertions.assertArrayEquals(b, new Sword_66().constructArr(a));
    }
}