package com.cshawn.leetcodes.crack;

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
 * @date 2021/3/12 9:21 下午
 */
class Q4_8Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            TreeNode p = new TreeNode(2);
            TreeNode q = new TreeNode(3);
            TreeNode pq = new TreeNode(3);
            return Stream.of(
                    Arguments.of(pq.left(p).right(q), p, q, pq),
                    Arguments.of(new TreeNode(1).left(p.right(q)), p, q, p)
//                    Arguments.of(new TreeNode(3).left(q.left(p.right(null))), p, q, q)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q, TreeNode result) {
        Assertions.assertEquals(result.val, new Q4_8().lowestCommonAncestor1(root, p, q).val);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode result) {
        Assertions.assertEquals(result.val, new Q4_8().lowestCommonAncestor(root, p, q).val);
    }
}