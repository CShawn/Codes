package com.cshawn.codes.leetcodes.everyday;


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
 * @date 2021/4/13 9:04 上午
 */
class Q783Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new TreeNode(5).left(new TreeNode(2)), 3),
                    Arguments.of(new TreeNode(5)
                            .left(new TreeNode(4).left(new TreeNode(2)))
                            .right(new TreeNode(7).right(new TreeNode(8))), 1),
                    Arguments.of(new TreeNode(5)
                            .left(new TreeNode(3))
                            .right(new TreeNode(8).right(new TreeNode(9))), 1),
                    Arguments.of(new TreeNode(5).left(new TreeNode(3)), 2),
                    Arguments.of(new TreeNode(5).right(new TreeNode(9)), 4),
                    Arguments.of(new TreeNode(5)
                            .right(new TreeNode(6).right(new TreeNode(9))), 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minDiffInBST(TreeNode tree, int result) {
        Assertions.assertEquals(result, new Q783().minDiffInBST1(tree));
        Assertions.assertEquals(result, new Q783().minDiffInBST(tree));
    }
}