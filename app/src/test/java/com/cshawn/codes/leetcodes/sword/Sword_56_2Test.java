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
 * @date 2021/1/24 1:24 下午
 */
class Sword_56_2Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,1,1,2}, 2),
                    Arguments.of(new int[]{2,1,1,1}, 2),
                    Arguments.of(new int[]{1,3,1,1}, 3),
                    Arguments.of(new int[]{1,1,4,1}, 4),
                    Arguments.of(new int[]{1,2,3,1,3,1,3}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void singleNumber(int[] array, int target) {
        Assertions.assertEquals(target, new Sword_56_2().singleNumber(array));
    }
}