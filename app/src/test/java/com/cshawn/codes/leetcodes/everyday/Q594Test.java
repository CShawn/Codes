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
 * @date 2021/11/20 2:50 下午
 */
class Q594Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,3,2,2,5,2,3,7}, 5),
                    Arguments.of(new int[]{1,2,3,4}, 2),
                    Arguments.of(new int[]{1,1,1,1}, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findLHS1(int[] nums, int result) {
        assertEquals(result, new Q594().findLHS1(nums));
        assertEquals(result, new Q594().findLHS(nums));
    }
}