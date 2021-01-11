package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/11 10:17 下午
 */
class Sword_42Test {
    private final Sword_42 test = new Sword_42();

    static class ArrayArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 0),
                    Arguments.of(new int[]{1,2,3}, 6),
                    Arguments.of(new int[]{-1,2,-3}, 2),
                    Arguments.of(new int[]{3,-2,1,5}, 7),
                    Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6),
                    Arguments.of(new int[]{4,-1,2,1}, 6)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ArrayArgumentsProvider.class)
    void maxSubArray(int[] array, int max) {
        assertEquals(max, test.maxSubArray(array));
    }
}