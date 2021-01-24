package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/24 11:37 上午
 */
class Sword_56Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,5}, new int[]{3,5}),
                    Arguments.of(new int[]{9,9,10,10,5,7}, new int[]{5,7})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void singleNumbers(int[] data, int[] result) {
        int[] a = new Sword_56().singleNumbers(data);
        Arrays.sort(a);
        Assertions.assertArrayEquals(result, a);
    }
}