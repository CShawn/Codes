package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/5/16 9:53 下午
 */
class Q421Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,10,5,25,2,8}, 28),
                    Arguments.of(new int[]{0}, 0),
                    Arguments.of(new int[]{2,4}, 6),
                    Arguments.of(new int[]{8,10,2}, 10),
                    Arguments.of(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}, 127)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findMaximumXOR(int[] nums, int result) {
        Assertions.assertEquals(result, new Q421().findMaximumXOR1(nums));
        Assertions.assertEquals(result, new Q421().findMaximumXOR(nums));
    }
}