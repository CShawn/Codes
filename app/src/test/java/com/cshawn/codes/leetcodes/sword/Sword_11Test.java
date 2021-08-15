package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2020/11/20 10:59
 */
public class Sword_11Test {
    public static class ArrayArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3, 4, 5, 1, 2}, 1),
                    Arguments.of(new int[]{2, 2, 2, 0, 1}, 0),
                    Arguments.of(new int[]{1, 2, 3}, 1),
                    Arguments.of(new int[0], -1),
                    Arguments.of(new int[]{1}, 1),
                    Arguments.of(new int[]{1, 1, 1}, 1),
                    Arguments.of(new int[]{1, 2, 3, 1}, 1),
                    Arguments.of(new int[]{3, 4, 1, 2}, 1),
                    Arguments.of(new int[]{3, 3, 1, 3}, 1),
                    Arguments.of(new int[]{4, 1, 2, 3}, 1)
            );
        }
    }
    private final Sword_11 test = new Sword_11();

    @ParameterizedTest(name = "case {index}: array = {1}, min = {2}")
    @ArgumentsSource(ArrayArgumentsProvider.class)
    public void minArray(int[] numbers, int min) {
        assertEquals(min, test.minArray(numbers));
    }

    @ParameterizedTest(name = "case {index}: array = {1}, min = {2}")
    @ArgumentsSource(ArrayArgumentsProvider.class)
    public void minArray2(int[] numbers, int min) {
        assertEquals(min, test.minArray2(numbers));
    }
}
