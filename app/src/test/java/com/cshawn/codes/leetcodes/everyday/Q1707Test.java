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
 * @date 2021/5/23 1:47 下午
 */
class Q1707Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,1,2,3,4}, new int[][]{{3,1},{1,3},{5,6}}, new int[]{3,3,7}),
                    Arguments.of(new int[]{5,2,4,6,6,3}, new int[][]{{12,4},{8,1},{6,3}}, new int[]{15,-1,5})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maximizeXor(int[] nums, int[][] queries, int[] result) {
        Assertions.assertArrayEquals(result, new Q1707().maximizeXor(nums, queries));
    }
}