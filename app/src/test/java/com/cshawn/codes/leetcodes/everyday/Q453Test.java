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
 * @date 2021/10/20 11:24 上午
 */
class Q453Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1}, 0),
                    Arguments.of(new int[]{1,3}, 2),
                    Arguments.of(new int[]{1,2,3}, 3),
                    Arguments.of(new int[]{-1,-2,-3}, 3),
                    Arguments.of(new int[]{-1,0,1}, 3),
                    Arguments.of(new int[]{2,2,2}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minMoves(int[] nums, int result) {
        assertEquals(result, new Q453().minMoves(nums));
    }
}