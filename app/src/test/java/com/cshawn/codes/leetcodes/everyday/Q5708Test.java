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
 * @date 2021/4/3 11:12 下午
 */
class Q5708Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{42,11,1,97}, 2),
                    Arguments.of(new int[]{13,10,35,24,76}, 4),
                    Arguments.of(new int[]{1,1,1,1,1}, 10)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void countNicePairs(int[] nums, int result) {
        Assertions.assertEquals(result, new Q5708().countNicePairs1(nums));
        Assertions.assertEquals(result, new Q5708().countNicePairs(nums));
    }
}