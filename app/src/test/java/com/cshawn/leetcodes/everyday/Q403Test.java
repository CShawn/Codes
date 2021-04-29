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
 * @date 2021/4/29 6:19 下午
 */
class Q403Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,1,3,5,6,8,12,17}, true),
                    Arguments.of(new int[]{0,1,2,3,4,8,9,11}, false),
                    Arguments.of(new int[]{0,1}, true),
                    Arguments.of(new int[]{0,2}, false),
                    Arguments.of(new int[]{0,1,3}, true),
                    Arguments.of(new int[]{0,1,4}, false),
                    Arguments.of(new int[]{0,1,3,4,8}, false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void canCross(int[] stones, boolean result) {
        Assertions.assertEquals(result, new Q403().canCross1(stones));
        Assertions.assertEquals(result, new Q403().canCross(stones));
    }
}