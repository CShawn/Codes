package com.cshawn.codes.leetcodes.crack;

import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/3/1 11:07 下午
 */
class Q4_2Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0]),
                    Arguments.of(new int[]{1, 3}),
                    Arguments.of(new int[]{1, 2, 3}),
                    Arguments.of(new int[]{1, 2, 3, 4}),
                    Arguments.of(new int[]{1, 2, 3, 4, 5})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void sortedArrayToBST(int[] nums) {
        TreeNode node = new Q4_2().sortedArrayToBST(nums);
        Assertions.assertArrayEquals(nums, node != null ? node.inOrder() : new int[0]);
    }
}