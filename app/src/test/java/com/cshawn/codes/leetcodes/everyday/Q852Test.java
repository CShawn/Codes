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
 * @date 2021/6/15 12:42 下午
 */
class Q852Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,1,0}, 1),
                    Arguments.of(new int[]{0,2,1,0}, 1),
                    Arguments.of(new int[]{0,10,5,2}, 1),
                    Arguments.of(new int[]{3,4,5,1}, 2),
                    Arguments.of(new int[]{24,69,100,99,79,78,67,36,26,19}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void peakIndexInMountainArray(int[] arr, int result) {
        Assertions.assertEquals(result, new Q852().peakIndexInMountainArray(arr));
    }
}