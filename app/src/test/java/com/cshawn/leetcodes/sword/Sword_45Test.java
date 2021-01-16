package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/15 9:56 下午
 */
class Sword_45Test {
    private final Sword_45 test = new Sword_45();

    static class ArrayArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], ""),
                    Arguments.of(new int[]{1,2,3}, "123"),
                    Arguments.of(new int[]{30,31,3,1}, "130313"),
                    Arguments.of(new int[]{3,0,4}, "034")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ArrayArgumentsProvider.class)
    void minNumber(int[] array, String min) {
        assertEquals(min, test.minNumber(array));
    }
}