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
 * @date 2021/7/26 6:46 下午
 */
class Q1713Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{5,1,3}, new int[]{9,4,2,3,4}, 2),
                    Arguments.of(new int[]{6,4,8,1,3,2}, new int[]{4,7,6,2,3,8,6,1}, 3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minOperations(int[] target, int[] arr, int result) {
        Assertions.assertEquals(result, new Q1713().minOperations1(target, arr));
        Assertions.assertEquals(result, new Q1713().minOperations(target, arr));
    }
}