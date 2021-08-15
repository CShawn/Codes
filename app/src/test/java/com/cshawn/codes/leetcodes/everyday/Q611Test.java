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
 * @date 2021/8/4 3:46 下午
 */
class Q611Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,2,3,4}, 3),
                    Arguments.of(new int[]{0,1,1,2,3,5,6}, 2),
                    Arguments.of(new int[]{2,2,3,4,5,6,9,10,8,0,7,7}, 90)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void triangleNumber(int[] nums, int result) {
        Assertions.assertEquals(result, new Q611().triangleNumber1(nums));
        Assertions.assertEquals(result, new Q611().triangleNumber(nums));
    }
}