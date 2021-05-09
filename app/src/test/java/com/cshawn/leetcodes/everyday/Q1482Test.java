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
 * @date 2021/5/9 4:51 下午
 */
class Q1482Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,10,3,10,2}, 3, 1, 3),
                    Arguments.of(new int[]{1,10,3,10,2}, 3, 2, -1),
                    Arguments.of(new int[]{7,7,7,7,12,7,7}, 2, 3, 12),
                    Arguments.of(new int[]{1,10,2,9,3,8,4,7,5,6}, 4, 2, 9),
                    Arguments.of(new int[]{1000000000,1000000000}, 1, 1, 1000000000)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minDays(int[] bloomDay, int m, int k, int result) {
        Assertions.assertEquals(result, new Q1482().minDays(bloomDay, m, k));
    }
}