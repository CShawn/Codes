package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
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
 * @date 2021/5/23 12:32 下午
 */
class Q5764Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,3,2}, 6, 1),
                    Arguments.of(new int[]{1,3,2}, 2.7, 3),
                    Arguments.of(new int[]{1,3,2}, 1.9, -1),
                    Arguments.of(new int[]{6,10,5,1,8,9,2}, 34.0, 2),
                    Arguments.of(new int[]{1,1,1,1,1,1,1,1,1,10}, 10, 10)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minSpeedOnTime(int[] dist, double hour, int result) {
        Assertions.assertEquals(result, new Q5764().minSpeedOnTime(dist, hour));
    }
}