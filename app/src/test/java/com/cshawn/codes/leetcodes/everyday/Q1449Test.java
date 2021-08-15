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
 * @date 2021/6/12 9:03 上午
 */
class Q1449Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{4,3,2,5,6,7,2,5,5}, 9, "7772"),
                    Arguments.of(new int[]{7,6,5,5,5,6,8,7,8}, 12, "85"),
                    Arguments.of(new int[]{2,4,6,2,4,6,4,4,4}, 5, "0"),
                    Arguments.of(new int[]{6,10,15,40,40,40,40,40,40}, 47, "32211"),
                    Arguments.of(new int[]{30,105,385,273,686,638,758,651,428}, 946, "99111")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void largestNumber(int[] cost, int target, String result) {
        Assertions.assertEquals(result, new Q1449().largestNumber1(cost, target));
        Assertions.assertEquals(result, new Q1449().largestNumber(cost, target));
    }
}