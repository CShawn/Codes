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
 * @date 2021/11/6 7:30 下午
 */
class Q268Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,0,1}, 2),
                    Arguments.of(new int[]{0,1}, 2),
                    Arguments.of(new int[]{9,6,4,2,3,5,7,0,1}, 8),
                    Arguments.of(new int[]{0}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void missingNumber(int[] nums, int result) {
        assertEquals(result, new Q268().missingNumber1(nums));
        assertEquals(result, new Q268().missingNumber2(nums));
        assertEquals(result, new Q268().missingNumber(nums));
    }
}