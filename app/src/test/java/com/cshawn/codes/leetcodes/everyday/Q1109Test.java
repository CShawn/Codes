package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/8/31 9:29 上午
 */
class Q1109Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,2,10},{2,3,20},{2,5,25}}, 5, new int[]{10,55,45,25,25}),
                    Arguments.of(new int[][]{{1,2,10},{2,2,15}}, 2, new int[]{10,25})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void corpFlightBookings(int[][] bookings, int n, int[] result) {
        Assertions.assertArrayEquals(result, new Q1109().corpFlightBookings(bookings, n));
    }
}