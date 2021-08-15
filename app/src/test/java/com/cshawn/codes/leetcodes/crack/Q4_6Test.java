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
 * @date 2021/3/12 4:44 下午
 */
class Q4_6Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            TreeNode p = new TreeNode(2);
            TreeNode p2 = new TreeNode(3).left(new TreeNode(2)).right(new TreeNode(4));
            return Stream.of(
                    Arguments.of(new TreeNode(3).left(p), p, 3),
                    Arguments.of(new TreeNode(1).left(new TreeNode(0)).right(p), p, null),
                    Arguments.of(new TreeNode(3).left(p).right(new TreeNode(4)), p, 3),
                    Arguments.of(new TreeNode(3).left(new TreeNode(1).right(p)).right(new TreeNode(4)), p, 3),
                    Arguments.of(new TreeNode(5).left(p2).right(new TreeNode(6)), p2, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void inorderSuccessor1(TreeNode tree, TreeNode p, Integer result) {
        TreeNode node = new Q4_6().inorderSuccessor1(tree, p);
        Assertions.assertEquals(result, node != null ? node.val : null);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void inorderSuccessor2(TreeNode tree, TreeNode p, Integer result) {
        TreeNode node = new Q4_6().inorderSuccessor2(tree, p);
        Assertions.assertEquals(result, node != null ? node.val : null);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void inorderSuccessor(TreeNode tree, TreeNode p, Integer result) {
        TreeNode node = new Q4_6().inorderSuccessor(tree, p);
        Assertions.assertEquals(result, node != null ? node.val : null);
    }
}