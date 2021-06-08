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
 * @date 2021/6/8 7:19 下午
 */
class Q1049Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,7,4,1,8,1}, 1),
                    Arguments.of(new int[]{31,26,33,21,40}, 5),
                    Arguments.of(new int[]{1,2}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void lastStoneWeightII(int[] stones, int result) {
        Assertions.assertEquals(result, new Q1049().lastStoneWeightII1(stones));
        Assertions.assertEquals(result, new Q1049().lastStoneWeightII2(stones));
        Assertions.assertEquals(result, new Q1049().lastStoneWeightII(stones));
    }
}