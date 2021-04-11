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
 * @date 2021/4/11 12:11 下午
 */
class Q5726Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,1,2}, 0),
                    Arguments.of(new int[]{-1,0,2}, 0),
                    Arguments.of(new int[]{-1,1,2,3}, -1),
                    Arguments.of(new int[]{-1,1,-2,3}, 1),
                    Arguments.of(new int[]{1,1,3,3,0}, 0),
                    Arguments.of(new int[]{3,4,5,6,6}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void arraySign(int[] nums, int result) {
        Assertions.assertEquals(result, new Q5726().arraySign1(nums));
        Assertions.assertEquals(result, new Q5726().arraySign2(nums));
        Assertions.assertEquals(result, new Q5726().arraySign(nums));
    }
}