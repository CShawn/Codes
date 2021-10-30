package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author C.Shawn
 * @date 2021/10/30 11:38 上午
 */
class Q260Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,1,3,2,5}, new int[]{3,5}),
                    Arguments.of(new int[]{1,2,1,3,2,5}, new int[]{3,5}),
                    Arguments.of(new int[]{-1,0}, new int[]{-1,0}),
                    Arguments.of(new int[]{0,1}, new int[]{0,1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void singleNumber(int[] nums, int[] result) {
        int[] res = new Q260().singleNumber(nums);
        Arrays.sort(res);
        assertArrayEquals(result, res);
    }
}