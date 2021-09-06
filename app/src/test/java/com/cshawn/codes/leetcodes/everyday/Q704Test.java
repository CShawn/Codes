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
 * @date 2021/9/6 9:13 上午
 */
class Q704Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{-1,0,3,5,9,12}, 9, 4),
                    Arguments.of(new int[]{-1,0,3,5,9,12}, -1, 0),
                    Arguments.of(new int[]{-1,0,3,5,9,12}, 0, 1),
                    Arguments.of(new int[]{-1,0,3,5,9,12}, 3, 2),
                    Arguments.of(new int[]{-1,0,3,5,9,12}, 5, 3),
                    Arguments.of(new int[]{-1,0,3,5,9,12}, 9, 4),
                    Arguments.of(new int[]{-1,0,3,5,9,12}, 12, 5),
                    Arguments.of(new int[]{-1,0,3,5,9,12}, 2, -1),
                    Arguments.of(new int[]{-1,0,3,5,9,12}, -12, -1),
                    Arguments.of(new int[]{-1,0,3,5,9,12}, 14, -1),
                    Arguments.of(new int[]{-1,0,3}, -1, 0),
                    Arguments.of(new int[]{-1,0,3}, 0, 1),
                    Arguments.of(new int[]{-1,0,3}, 3, 2),
                    Arguments.of(new int[]{-1,0,3}, 1, -1),
                    Arguments.of(new int[]{-1,0,3}, -2, -1),
                    Arguments.of(new int[]{-1,0,3}, 4, -1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void search(int[] nums, int target, int result) {
        assertEquals(result, new Q704().search(nums, target));
    }
}