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
 * @date 2021/5/9 11:14 上午
 */
class Q5752Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,2}, 14),
                    Arguments.of(new int[]{2,3,3,1,2}, 18),
                    Arguments.of(new int[]{3,1,5,6,4,2}, 60),
                    Arguments.of(new int[]{1,1,3,2,2,2,1,5,1,5}, 25)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxSumMinProduct(int[] nums, int result) {
        Assertions.assertEquals(result, new Q5752().maxSumMinProduct1(nums));
        Assertions.assertEquals(result, new Q5752().maxSumMinProduct2(nums));
        Assertions.assertEquals(result, new Q5752().maxSumMinProduct3(nums));
        Assertions.assertEquals(result, new Q5752().maxSumMinProduct4(nums));
    }
}