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
 * @date 2021/11/1 8:05 上午
 */
class Q575Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,1,2,2,3,3}, 3),
                    Arguments.of(new int[]{1,1,2,3}, 2),
                    Arguments.of(new int[]{1,2}, 1),
                    Arguments.of(new int[]{1,2,3,4}, 2),
                    Arguments.of(new int[]{1,1,1,1}, 1),
                    Arguments.of(new int[]{1,2,2,2}, 2),
                    Arguments.of(new int[]{1,1,2,3}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void distributeCandies(int[] candyType, int result) {
        assertEquals(result, new Q575().distributeCandies1(candyType));
        assertEquals(result, new Q575().distributeCandies(candyType));
    }
}