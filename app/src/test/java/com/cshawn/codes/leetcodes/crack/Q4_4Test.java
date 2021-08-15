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
 * @date 2021/3/8 9:35 下午
 */
class Q4_4Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, true),
                    Arguments.of(new TreeNode(1), true),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)), true),
                    Arguments.of(new TreeNode(1)
                                    .left(new TreeNode(2).left(new TreeNode(4)))
                                    .right(new TreeNode(3).right(new TreeNode(7))), true),
                    Arguments.of(new TreeNode(1)
                                    .left(new TreeNode(2))
                                    .right(new TreeNode(3).right(new TreeNode(7))), true),
                    Arguments.of(new TreeNode(1)
                            .right(new TreeNode(3).right(new TreeNode(7))), false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isBalanced(TreeNode tree, boolean result) {
        Assertions.assertEquals(result, new Q4_4().isBalanced1(tree));
        Assertions.assertEquals(result, new Q4_4().isBalanced(tree));
    }
}