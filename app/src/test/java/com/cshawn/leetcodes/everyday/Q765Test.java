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
 * @date 2021/2/14 11:37 上午
 */
class Q765Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,1,2,3}, 0),
                    Arguments.of(new int[]{1,0,2,3}, 0),
                    Arguments.of(new int[]{1,0,3,2}, 0),
                    Arguments.of(new int[]{3,2,1,0}, 0),
                    Arguments.of(new int[]{2,3,0,1}, 0),
                    Arguments.of(new int[]{3,1,2,0}, 1),
                    Arguments.of(new int[]{0,2,3,1}, 1),
                    Arguments.of(new int[]{3,1,2,0,5,4}, 1),
                    Arguments.of(new int[]{3,2,1,0,5,4}, 0),
                    Arguments.of(new int[]{3,5,1,4,2,0}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minSwapsCouples(int[] row, int result) {
        Assertions.assertEquals(result, new Q765().minSwapsCouples(row));
    }
}