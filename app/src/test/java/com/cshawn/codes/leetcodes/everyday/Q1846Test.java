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
 * @date 2021/7/15 5:05 下午
 */
class Q1846Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,2,1,2,1}, 2),
                    Arguments.of(new int[]{100,1,1000}, 3),
                    Arguments.of(new int[]{1,2,3,4,5}, 5),
                    Arguments.of(new int[]{7,8,9},3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maximumElementAfterDecrementingAndRearranging(int[] arr, int result) {
        Assertions.assertEquals(result, new Q1846().maximumElementAfterDecrementingAndRearranging1(arr));
        Assertions.assertEquals(result, new Q1846().maximumElementAfterDecrementingAndRearranging(arr));
    }
}