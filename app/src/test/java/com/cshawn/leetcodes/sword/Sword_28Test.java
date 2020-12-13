package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @Date 2020/12/13 22:01
 */
class Sword_28Test {
    private final Sword_28 test = new Sword_28();

    static class TreeNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((TreeNode)null, false),
                    Arguments.of(new TreeNode(1), true),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)), false),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)).right(new TreeNode(2)), true),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).left(new TreeNode(4)).right(new TreeNode(5)))
                                    .right(new TreeNode(2).left(new TreeNode(5)).right(new TreeNode(4))), true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    void isSymmetric(TreeNode tree, boolean isSymmetric) {
        assertEquals(isSymmetric, test.isSymmetric(tree));
    }
}