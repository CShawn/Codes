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
 * @date 2021/8/26 8:46 上午
 */
class Q881Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,1}, 3, 1),
                    Arguments.of(new int[]{2,4}, 5, 2),
                    Arguments.of(new int[]{2,2}, 6, 1),
                    Arguments.of(new int[]{1, 2, 3}, 3, 2),
                    Arguments.of(new int[]{3,2,2,1}, 3, 3),
                    Arguments.of(new int[]{3,5,3,4}, 5, 4),
                    Arguments.of(new int[]{5,4,3,2,1}, 5, 3),
                    Arguments.of(new int[]{5,1,4,2}, 6, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void numRescueBoats(int[] people, int limit, int result) {
        Assertions.assertEquals(result, new Q881().numRescueBoats(people, limit));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void numRescueBoats1(int[] people, int limit, int result) {
        Assertions.assertEquals(result, new Q881().numRescueBoats1(people, limit));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void numRescueBoats2(int[] people, int limit, int result) {
        Assertions.assertEquals(result, new Q881().numRescueBoats2(people, limit));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void numRescueBoats22(int[] people, int limit, int result) {
        Assertions.assertEquals(result, new Q881().numRescueBoats22(people, limit));
    }
}