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
 * @date 2021/2/23 10:31 上午
 */
class Q1052Test {

    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3, 16),
                    Arguments.of(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 0, 10),
                    Arguments.of(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, -8, 10),
                    Arguments.of(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 1, 15),
                    Arguments.of(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 9, 18),
                    Arguments.of(new int[]{1,0,1,2,1,1,7,5}, new int[]{1,1,0,1,0,0,0,0}, 3, 17)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxSatisfied(int[] customers, int[] grumpy, int x, int result) {
        Assertions.assertEquals(result, new Q1052().maxSatisfied1(customers, grumpy, x));
        Assertions.assertEquals(result, new Q1052().maxSatisfied(customers, grumpy, x));
    }
}