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
 * @date 2021/9/8 10:03 上午
 */
class Q502Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(2, 0, new int[]{1,2,3}, new int[]{0,1,1}, 4),
                    Arguments.of(3, 0, new int[]{1,2,3}, new int[]{0,1,1}, 6),
                    Arguments.of(8, 0, new int[]{1,2,3}, new int[]{0,1,1}, 6),
                    Arguments.of(8, 0, new int[]{1,1,3}, new int[]{0,1,3}, 2),
                    Arguments.of(3, 0, new int[]{1,2,3}, new int[]{1,1,1}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findMaximizedCapital(int k, int w, int[] profits, int[] capital, int result) {
        assertEquals(result, new Q502().findMaximizedCapital(k, w, profits, capital));
    }
}