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
 * @date 2021/9/20 11:46 上午
 */
class Q673Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,3,5,4,7}, 2),
                    Arguments.of(new int[]{2,2,2,2,2}, 5),
                    Arguments.of(new int[]{3,1,2}, 1),
                    Arguments.of(new int[]{1,2,4,3,5,4,7,2}, 3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findNumberOfLIS(int[] nums, int result) {
        assertEquals(result, new Q673().findNumberOfLIS(nums));
    }
}