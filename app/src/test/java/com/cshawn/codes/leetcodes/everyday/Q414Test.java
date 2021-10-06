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
 * @date 2021/10/6 10:13 下午
 */
class Q414Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3, 2, 1}, 1),
                    Arguments.of(new int[]{1,2}, 2),
                    Arguments.of(new int[]{2, 2, 3, 1}, 1),
                    Arguments.of(new int[]{2,2,2,2}, 2),
                    Arguments.of(new int[]{5,2,2}, 5)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void thirdMax(int[] nums, int result) {
        assertEquals(result, new Q414().thirdMax1(nums));
        assertEquals(result, new Q414().thirdMax2(nums));
        assertEquals(result, new Q414().thirdMax(nums));
    }
}