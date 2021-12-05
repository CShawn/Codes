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
 * @date 2021/12/5 12:31 下午
 */
class Q372Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(2, new int[]{3}, 8),
                    Arguments.of(2, new int[]{1,0}, 1024),
                    Arguments.of(1, new int[]{4,3,3,8,5,2}, 1),
                    Arguments.of(2147483647, new int[]{2,0,0}, 1198)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void superPow(int a, int[] b, int result) {
        assertEquals(result, new Q372().superPow(a, b));
    }
}