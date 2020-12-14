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
 * @date 2020/12/14 22:53
 */
class Sword_31Test {
    private final Sword_31 test = new Sword_31();

    static class StackArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], new int[0], true),
                    Arguments.of(new int[]{1}, new int[]{1}, true),
                    Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, true),
                    Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3, 2}, true),
                    Arguments.of(new int[]{1, 2, 3}, new int[]{2, 1, 3}, true),
                    Arguments.of(new int[]{1, 2, 3}, new int[]{2, 3, 1}, true),
                    Arguments.of(new int[]{1, 2, 3}, new int[]{3, 1, 2}, false),
                    Arguments.of(new int[]{1, 2, 3}, new int[]{3, 2, 1}, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(StackArgumentsProvider.class)
    void validateStackSequences(int[] pushed, int[] popped, boolean valid) {
        assertEquals(valid, test.validateStackSequences(pushed, popped));
    }
}