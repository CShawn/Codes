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
 * @date 2021/10/29 3:59 下午
 */
class Q335Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,1,1,2}, true),
                    Arguments.of(new int[]{1,2,3,4}, false),
                    Arguments.of(new int[]{1,2,3,4}, false),
                    Arguments.of(new int[]{1,1,2,1,2}, true),
                    Arguments.of(new int[]{1,1,2,2,1,1}, true),
                    Arguments.of(new int[]{2,2,3,3,2,2}, true),
                    Arguments.of(new int[]{1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1}, false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isSelfCrossing(int[] distance, boolean result) {
        assertEquals(result, new Q335().isSelfCrossing(distance));
    }
}