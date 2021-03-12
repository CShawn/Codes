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
 * @date 2021/3/8 10:05 下午
 */
class Q4_5Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, true),
                    Arguments.of(new TreeNode(1), true),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)), false),
                    Arguments.of(new TreeNode(2).left(new TreeNode(1)), true),
                    Arguments.of(new TreeNode(2).right(new TreeNode(1)), false),
                    Arguments.of(new TreeNode(2).right(new TreeNode(3)), true),
                    Arguments.of(new TreeNode(3)
                            .left(new TreeNode(2).left(new TreeNode(4)))
                            .right(new TreeNode(5).right(new TreeNode(7))), false),
                    Arguments.of(new TreeNode(3)
                            .left(new TreeNode(1).right(new TreeNode(2)))
                            .right(new TreeNode(4).right(new TreeNode(5))), true),
                    //      3
                    //   1     5
                    //  0 2   4  6
                    //     3
                    Arguments.of(new TreeNode(3)
                            .left(new TreeNode(1).left(new TreeNode(0)).right(new TreeNode(2).right(new TreeNode(3))))
                            .right(new TreeNode(5).left(new TreeNode(4)).right(new TreeNode(6))), false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isValidBST(TreeNode tree, boolean result) {
        Assertions.assertEquals(result, new Q4_5().isValidBST(tree));
    }
}