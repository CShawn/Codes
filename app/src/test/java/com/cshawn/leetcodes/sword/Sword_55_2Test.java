package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/1/23 10:21 下午
 */
class Sword_55_2Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, true),
                    Arguments.of(new TreeNode(1), true),
                    Arguments.of(new TreeNode(2).left(new TreeNode(1)), true),
                    Arguments.of(new TreeNode(2).right(new TreeNode(3)), true),
                    Arguments.of(new TreeNode(2).left(new TreeNode(1)).right(new TreeNode(3)), true),
                    Arguments.of(new TreeNode(1).right(new TreeNode(2).right(new TreeNode(3))), false),
                    Arguments.of(new TreeNode(3).left(new TreeNode(2).left(new TreeNode(1))), false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isBalanced(TreeNode tree, boolean isBalanced) {
        Assertions.assertEquals(isBalanced, new Sword_55_2().isBalanced(tree));
    }
}