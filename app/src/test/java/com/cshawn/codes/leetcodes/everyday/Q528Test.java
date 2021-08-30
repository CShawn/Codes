package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/8/30 10:53 上午
 */
class Q528Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1}, new int[]{1}, new int[]{0}),
                    Arguments.of(new int[]{1,1,1}, new int[]{1,2,3}, new int[]{0,1,2}),
                    Arguments.of(new int[]{1,1,1,1}, new int[]{1,2,3,4}, new int[]{0,1,2,3}),
                    Arguments.of(new int[]{1,2,3,4}, new int[]{1,2,3,4,5,6,7,8,9,10}, new int[]{0,1,1,2,2,2,3,3,3,3})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void test(int[] arr, int[] target, int[] result) {
        Q528.Solution test = new Q528.Solution(arr);
        for (int i = 0; i < target.length; i++) {
            assertEquals(result[i], test.pick(target[i]));
        }
    }
}