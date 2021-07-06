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
 * @date 2021/7/6 10:31 上午
 */
class Q11Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                    Arguments.of(new int[]{1,1}, 1),
                    Arguments.of(new int[]{4,3,2,1,4}, 16),
                    Arguments.of(new int[]{1,2,1}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxArea(int[] height, int result) {
        Assertions.assertEquals(result, new Q11().maxArea(height));
    }
}