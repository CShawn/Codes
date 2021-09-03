package com.cshawn.codes.leetcodes.interview;

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
 * @date 2021/9/3 9:28 上午
 */
class Q17_14Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,3}, 0, new int[0]),
                    Arguments.of(new int[]{3,2,1}, 1, new int[]{1}),
                    Arguments.of(new int[]{3,2,1}, 3, new int[]{1,2,3}),
                    Arguments.of(new int[]{1,3,5,7,2,4,6,8}, 4, new int[]{1,2,3,4}),
                    Arguments.of(new int[]{1,3,5,7,9,23,7,31,5,15,2,4,6,8}, 4, new int[]{1,2,3,4})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void smallestK(int[] arr, int k, int[] result) {
        int[] res1 = new Q17_14().smallestK1(arr, k);
        Arrays.sort(res1);
        assertArrayEquals(result, res1);
        int[] res = new Q17_14().smallestK(arr, k);
        Arrays.sort(res);
        assertArrayEquals(result, res);
    }
}