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
 * @date 2021/5/4 10:09 下午
 */
class Q137Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,2,3,2}, 3),
                    Arguments.of(new int[]{0,1,0,1,0,1,99}, 99)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void singleNumber(int[] nums, int result) {
        Assertions.assertEquals(result, new Q137().singleNumber1(nums));
        Assertions.assertEquals(result, new Q137().singleNumber2(nums));
        Assertions.assertEquals(result, new Q137().singleNumber3(nums));
        Assertions.assertEquals(result, new Q137().singleNumber1(nums));
    }
}