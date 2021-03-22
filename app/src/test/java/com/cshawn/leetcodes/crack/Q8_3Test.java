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
 * @date 2021/3/22 11:08 下午
 */
class Q8_3Test {

    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{0, 2, 3, 4, 5}, 0),
                    Arguments.arguments(new int[]{1, 1, 1}, 1),
                    Arguments.arguments(new int[]{1, 2, 3, 4, 4, 4, 4}, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void findMagicIndex(int[] nums, int result) {
        Assertions.assertEquals(result, new Q8_3().findMagicIndex(nums));
    }
}