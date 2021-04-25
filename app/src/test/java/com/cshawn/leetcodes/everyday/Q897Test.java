package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/4/25 6:10 下午
 */
class Q897Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, new int[0]),
                    Arguments.of(new TreeNode(new Integer[]{5,3,6,2,4,null,8,1,null,null,null,7,9}), new int[]{1,2,3,4,5,6,7,8,9}),
                    Arguments.of(new TreeNode(new Integer[]{5,1,7}), new int[]{1,5,7})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void increasingBST(TreeNode root, int[] result) {
        TreeNode node = new Q897().increasingBST(root);
        Assertions.assertArrayEquals(result, node == null ? new int[0] : node.inOrder());
    }
}