package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/12/20 9:15 上午
 */
class Q475Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3}, new int[]{2}, 1),
                    Arguments.of(new int[]{1,2,3,4}, new int[]{1,4}, 1),
                    Arguments.of(new int[]{1,5}, new int[]{2}, 3),
                    Arguments.of(new int[]{5,6}, new int[]{1,7}, 2),
                    Arguments.of(new int[]{5,6}, new int[]{5,6}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findRadius(int[] houses, int[] heaters, int result) {
        assertEquals(result, new Q475().findRadius(houses, heaters));
    }
}