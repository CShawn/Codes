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
 * @date 2021/7/26 5:31 下午
 */
class Q300Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{10,9,2,5,3,7,101,18}, 4),
                    Arguments.of(new int[]{0,1,0,3,2,3}, 4),
                    Arguments.of(new int[]{7,7,7,7,7,7,7}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void lengthOfLIS(int[] nums, int result) {
        Assertions.assertEquals(result, new Q300().lengthOfLIS1(nums));
        Assertions.assertEquals(result, new Q300().lengthOfLIS(nums));
    }
}