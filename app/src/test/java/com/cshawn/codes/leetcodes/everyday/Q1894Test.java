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
 * @date 2021/9/10 9:06 上午
 */
class Q1894Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{5}, 6, 0),
                    Arguments.of(new int[]{5}, 5, 0),
                    Arguments.of(new int[]{5}, 1, 0),
                    Arguments.of(new int[]{5,1,5}, 22, 0),
                    Arguments.of(new int[]{5,1,5}, 6, 2),
                    Arguments.of(new int[]{3,4,1,2}, 25, 1),
                    Arguments.of(new int[]{2,5,3}, 11, 0),
                    Arguments.of(new int[]{2,5,3}, 19, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void chalkReplacer(int[] chalk, int k, int result) {
        Assertions.assertEquals(result, new Q1894().chalkReplacer(chalk, k));
    }
}