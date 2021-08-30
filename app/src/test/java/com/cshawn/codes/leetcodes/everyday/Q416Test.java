package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/8/30 3:33 下午
 */
class Q416Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,5,11,5}, true),
                    Arguments.of(new int[]{1,2,3,5}, false),
                    Arguments.of(new int[]{2,4,6}, true),
                    Arguments.of(new int[]{2,4,6,10}, false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void canPartition(int[] nums, boolean result) {
        assertEquals(result, new Q416().canPartition1(nums));
        assertEquals(result, new Q416().canPartition(nums));
    }
}