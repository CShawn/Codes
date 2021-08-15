package com.cshawn.codes.leetcodes.sword;

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
 * @date 2021/1/28 12:07 下午
 */
class Sword_68_1Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            TreeNode one = new TreeNode(1);
            TreeNode two = new TreeNode(2);
            return Stream.of(
                    Arguments.of(null, null, null, null),
                    Arguments.of(one, one, one, one),
                    Arguments.of(two.left(one), one, two, two)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode result) {
        Assertions.assertEquals(result, new Sword_68_1().lowestCommonAncestor(root, p, q));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q, TreeNode result) {
        Assertions.assertEquals(result, new Sword_68_1().lowestCommonAncestor2(root, p, q));
    }
}