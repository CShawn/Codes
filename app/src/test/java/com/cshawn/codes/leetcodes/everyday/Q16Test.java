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
 * @date 2021/7/7 4:40 下午
 */
class Q16Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{-1,2,1,-4}, 1, 2),
                    Arguments.of(new int[]{-100,-98,-2,-1}, -101, -101)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void threeSumClosest1(int[] nums, int target, int result) {
        Assertions.assertEquals(result, new Q16().threeSumClosest1(nums, target));
        Assertions.assertEquals(result, new Q16().threeSumClosest(nums, target));
    }
}