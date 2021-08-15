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
 * @date 2021/8/3 5:09 下午
 */
class Q581Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,6,4,8,10,9,15}, 5),
                    Arguments.of(new int[]{1, 1, 3, 4}, 0),
                    Arguments.of(new int[]{1}, 0),
                    Arguments.of(new int[]{1, 2, 7, 8, 5, 6, 9, 10}, 4),
                    Arguments.of(new int[]{1, 2, 7, 8, 5, 6, 10, 9}, 6),
                    Arguments.of(new int[]{7, 8, 5, 6, 10, 9}, 6),
                    Arguments.of(new int[]{7, 8, 5, 6, 9, 10}, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findUnsortedSubarray(int[] nums, int result) {
        Assertions.assertEquals(result, new Q581().findUnsortedSubarray1(nums));
        Assertions.assertEquals(result, new Q581().findUnsortedSubarray(nums));
    }
}