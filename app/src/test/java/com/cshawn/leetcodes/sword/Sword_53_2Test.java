package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/1/23 8:11 下午
 */
class Sword_53_2Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1}, 0),
                    Arguments.of(new int[]{1,2}, 0),
                    Arguments.of(new int[]{0,2}, 1),
                    Arguments.of(new int[]{1,2,3}, 0),
                    Arguments.of(new int[]{1,2,3}, 0),
                    Arguments.of(new int[]{0,2,3}, 1),
                    Arguments.of(new int[]{0,1,3}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void missingNumber(int[] nums, int n) {
        assertEquals(n, new Sword_53_2().missingNumber(nums));
    }
}