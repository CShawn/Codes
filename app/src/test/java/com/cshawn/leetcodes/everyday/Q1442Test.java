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
 * @date 2021/5/18 9:22 下午
 */
class Q1442Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,3,1,6,7}, 4),
                    Arguments.of(new int[]{1,1,1,1,1}, 10),
                    Arguments.of(new int[]{2,3}, 0),
                    Arguments.of(new int[]{1,3,5,7,9}, 3),
                    Arguments.of(new int[]{7,11,12,9,5,2,7,17,22}, 8)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void countTriplets(int[] arr, int result) {
        Assertions.assertEquals(result, new Q1442().countTriplets1(arr));
        Assertions.assertEquals(result, new Q1442().countTriplets2(arr));
        Assertions.assertEquals(result, new Q1442().countTriplets3(arr));
        Assertions.assertEquals(result, new Q1442().countTriplets(arr));
    }
}