package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/3/21 9:09 下午
 */
class Q5_8Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(1,32,30,31,0,new int[]{3}),
                    Arguments.arguments(3,96,0,95,0,new int[]{-1,-1,-1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void drawLine(int length, int w, int x1, int x2, int y, int[] result) {
        Assertions.assertArrayEquals(result, new Q5_8().drawLine1(length, w, x1, x2, y));
        Assertions.assertArrayEquals(result, new Q5_8().drawLine(length, w, x1, x2, y));
    }
}