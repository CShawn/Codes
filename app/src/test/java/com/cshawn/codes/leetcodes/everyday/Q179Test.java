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
 * @date 2021/4/12 4:35 下午
 */
class Q179Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{12,3}, "312"),
                    Arguments.of(new int[]{3,30,34,5,9}, "9534330"),
                    Arguments.of(new int[]{1}, "1"),
                    Arguments.of(new int[]{0,0,0}, "0"),
                    Arguments.of(new int[]{0}, "0"),
                    Arguments.of(new int[]{123456789,23456789}, "23456789123456789"),
                    Arguments.of(new int[]{1,2,3,4,5,6,7,8,9,0}, "9876543210")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void largestNumber(int[] nums, String result) {
        Assertions.assertEquals(result, new Q179().largestNumber1(nums));
        Assertions.assertEquals(result, new Q179().largestNumber(nums));
    }
}