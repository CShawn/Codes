package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author C.Shawn
 * @date 2021/9/15 4:53 下午
 */
class Q162Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2}, new int[]{1}),
                    Arguments.of(new int[]{1,2,3,1}, new int[]{2}),
                    Arguments.of(new int[]{1,2,1,3,5,6,4}, new int[]{1,5}),
                    Arguments.of(new int[]{1}, new int[]{0}),
                    Arguments.of(new int[]{2,1}, new int[]{0})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findPeakElement(int[] nums, int[] result) {
        boolean r1 = false;
        boolean r2 = false;
        int res1 = new Q162().findPeakElement1(nums);
        int res2 = new Q162().findPeakElement(nums);
        for (int i : result) {
            r1 |= res1 == i;
            r2 |= res2 == i;
            if (r1 && r2) {
                break;
            }
        }
        assertTrue(r1 && r2);
    }
}