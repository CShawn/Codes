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
 * @date 2021/1/20 11:15 上午
 */
class Sword_53_1Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], 3, 0),
                    Arguments.of(new int[]{1,2}, 3, 0),
                    Arguments.of(new int[]{1,2}, 2, 1),
                    Arguments.of(new int[]{1,2}, 1, 1),
                    Arguments.of(new int[]{2,2}, 1, 0),
                    Arguments.of(new int[]{1,2,3}, 2, 1),
                    Arguments.of(new int[]{1,2,2}, 2, 2),
                    Arguments.of(new int[]{2,2,2}, 2, 3),
                    Arguments.of(new int[]{2,2,6}, 3, 0),
                    Arguments.of(new int[]{1,2,2,3}, 2, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void search(int[] nums, int target, int length) {
        assertEquals(length, new Sword_53_1().search1(nums, target));
        assertEquals(length, new Sword_53_1().search(nums, target));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void search2(int[] nums, int target, int length) {
        assertEquals(length, new Sword_53_1().search2(nums, target));
    }
}