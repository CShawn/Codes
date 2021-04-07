package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/4/7 5:37 下午
 */
class Q33Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
//                    Arguments.of(new int[]{4,5,6,7,0,1,2}, 0, 4),
//                    Arguments.of(new int[]{4,5,6,7,0,1,2}, 3, -1),
//                    Arguments.of(new int[]{0,1,2,4,5,6,7}, 2, 2),
//                    Arguments.of(new int[]{0,1,2,4,5,6,7}, 0, 0),
//                    Arguments.of(new int[]{0,1,2,4,5,6,7}, 7, 6),
//                    Arguments.of(new int[]{4}, 3, -1),
                    Arguments.of(new int[]{3,1}, 1, 1),
                    Arguments.of(new int[0], 3, -1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void search(int[] nums, int target, int result) {
        Assertions.assertEquals(result, new Q33().search1(nums, target));
        Assertions.assertEquals(result, new Q33().search(nums, target));
    }
}