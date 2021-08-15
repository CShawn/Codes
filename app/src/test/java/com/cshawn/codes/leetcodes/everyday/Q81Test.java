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
 * @date 2021/4/7 10:09 下午
 */
class Q81Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{4,5,6,7,0,1,2}, 0, true),
                    Arguments.of(new int[]{4,5,6,7,0,1,2}, 3, false),
                    Arguments.of(new int[]{2,5,6,0,0,1,2}, 3, false),
                    Arguments.of(new int[]{2,5,6,0,0,1,2}, 0, true),
                    Arguments.of(new int[]{4}, 3, false),
                    Arguments.of(new int[]{3,1}, 1, true),
                    Arguments.of(new int[]{3,1,3}, 1, true),
                    Arguments.of(new int[]{3,1,3}, 3, true),
                    Arguments.of(new int[0], 3, false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void search(int[] nums, int target, boolean result) {
        Assertions.assertEquals(result, new Q81().search(nums, target));
    }
}