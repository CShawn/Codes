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
 * @date 2021/8/8 10:25 上午
 */
class Q457Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{2,-1,1,2,2}, true),
                    Arguments.arguments(new int[]{-1,2}, false),
                    Arguments.arguments(new int[]{-2,1,-1,-2,-2}, false),
                    Arguments.arguments(new int[]{1,1,2}, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void circularArrayLoop1(int[] nums, boolean result) {
        Assertions.assertEquals(result, new Q457().circularArrayLoop1(nums));
        Assertions.assertEquals(result, new Q457().circularArrayLoop(nums));
    }
}