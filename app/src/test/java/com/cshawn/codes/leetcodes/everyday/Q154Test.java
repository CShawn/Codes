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
 * @date 2021/4/9 11:24 上午
 */
class Q154Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{4,5,6,7,8,1,2}, 1),
                    Arguments.of(new int[]{5,6,0,1,2,3,4}, 0),
                    Arguments.of(new int[]{0,1,2,4,5,6,7}, 0),
                    Arguments.of(new int[]{4}, 4),
                    Arguments.of(new int[]{3,1}, 1),
                    Arguments.of(new int[]{1,3}, 1),
                    Arguments.of(new int[]{2,2,2,0,1}, 0),
                    Arguments.of(new int[]{2,2,2,0,2}, 0),
                    Arguments.of(new int[]{1,2,2,0,1}, 0),
                    Arguments.of(new int[]{2,2,2,0,1}, 0),
                    Arguments.of(new int[]{0,1,2,2,3}, 0),
                    Arguments.of(new int[]{0,1,2,2,2}, 0),
                    Arguments.of(new int[]{3,0,1,2,2}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findMin(int[] nums, int result) {
        Assertions.assertEquals(result, new Q154().findMin(nums));
    }
}