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
 * @date 2021/2/18 10:51 下午
 */
class Q995Test {

    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,1,0}, 1, 2),
                    Arguments.of(new int[]{1,1,0}, 2, -1),
                    Arguments.of(new int[]{0,0,0,1,0,1,1,0}, 3, 3),
                    Arguments.of(new int[]{0,0,0,1,0,1}, 3, -1),
                    Arguments.of(new int[]{0,0,0,1,0,1,1}, 3, -1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minKBitFlips(int[] nums, int k, int result) {
        Assertions.assertEquals(result, new Q995().minKBitFlips(nums, k));
        Assertions.assertEquals(result, new Q995().minKBitFlips1(nums, k));
    }
}