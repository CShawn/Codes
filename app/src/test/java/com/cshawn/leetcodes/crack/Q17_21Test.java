package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/4/2 4:30 下午
 */
class Q17_21Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6),
                    Arguments.arguments(new int[]{4,2,0,3,2,5}, 9),
                    Arguments.arguments(new int[]{0,1,2,3}, 0),
                    Arguments.arguments(new int[]{3,2,1,1,0}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void trap(int[] height, int result) {
        Assertions.assertEquals(result, new Q17_21().trap1(height));
        Assertions.assertEquals(result, new Q17_21().trap2(height));
        Assertions.assertEquals(result, new Q17_21().trap(height));
    }
}