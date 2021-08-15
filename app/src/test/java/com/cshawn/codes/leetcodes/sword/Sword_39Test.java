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
 * @date 2021/1/7 10:05 下午
 */
class Sword_39Test {
    private final Sword_39 test = new Sword_39();

    static class StringArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 0),
                    Arguments.of(new int[]{1}, 1),
                    Arguments.of(new int[]{1, 1, 2}, 1),
                    Arguments.of(new int[]{1, 2, 3, 3, 3}, 3),
                    Arguments.of(new int[]{1, 1, 1, 1, 1}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(StringArgumentsProvider.class)
    void majorityElement(int nums[], int num) {
        Assertions.assertEquals(num, test.majorityElement(nums));
    }
}