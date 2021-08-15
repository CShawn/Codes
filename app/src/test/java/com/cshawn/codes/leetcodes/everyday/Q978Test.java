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
 * @date 2021/2/8 3:03 下午
 */
class Q978Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 0),
                    Arguments.of(new int[]{1}, 1),
                    Arguments.of(new int[]{1,2}, 2),
                    Arguments.of(new int[]{1,1}, 1),
                    Arguments.of(new int[]{2,1}, 2),
                    Arguments.of(new int[]{1,2,1}, 3),
                    Arguments.of(new int[]{1,1,1}, 1),
                    Arguments.of(new int[]{1,1,2}, 2),
                    Arguments.of(new int[]{1,1,0}, 2),
                    Arguments.of(new int[]{1,2,2}, 2),
                    Arguments.of(new int[]{2,1,1}, 2),
                    Arguments.of(new int[]{1,2,3}, 2),
                    Arguments.of(new int[]{3,2,1}, 2),
                    Arguments.of(new int[]{3,1,2}, 3),
                    Arguments.of(new int[]{3,1,2,0}, 4),
                    Arguments.of(new int[]{3,1,2,0,0,2,1,4,3}, 5)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxTurbulenceSize(int[] nums, int result) {
        Assertions.assertEquals(result, new Q978().maxTurbulenceSize(nums));
        Assertions.assertEquals(result, new Q978().maxTurbulenceSize1(nums));
        Assertions.assertEquals(result, new Q978().maxTurbulenceSize2(nums));
    }
}