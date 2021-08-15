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
 * @date 2021/6/7 7:11 下午
 */
class Q494Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,1,1,1,1}, 3, 5),
                    Arguments.of(new int[]{1}, 1, 1),
                    Arguments.of(new int[]{1,1,1,1,1,2,4,2,5,6,1,1}, 14, 129)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findTargetSumWays(int[] nums, int target, int result) {
        Assertions.assertEquals(result, new Q494().findTargetSumWays1(nums, target));
        Assertions.assertEquals(result, new Q494().findTargetSumWays2(nums, target));
        Assertions.assertEquals(result, new Q494().findTargetSumWays3(nums, target));
        Assertions.assertEquals(result, new Q494().findTargetSumWays(nums, target));
    }
}