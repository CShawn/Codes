package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/12/24 8:56 上午
 */
class Q1705Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}, 7),
                    Arguments.of(new int[]{4,2,0,5,4}, new int[]{2,3,0,4,8}, 11),
                    Arguments.of(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}, 5),
                    Arguments.of(new int[]{2,2}, new int[]{4,2}, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void eatenApples(int[] apples, int[] days, int result) {
        assertEquals(result, new Q1705().eatenApples(apples, days));
    }
}