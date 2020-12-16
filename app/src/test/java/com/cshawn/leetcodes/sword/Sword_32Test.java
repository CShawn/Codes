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
 * @date 2020/12/16 10:17 上午
 */
class Sword_32Test {
    private final Sword_32 test = new Sword_32();

    static class TreeNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((TreeNode)null, new int[0]),
                    Arguments.of(new TreeNode(1), new int[]{1}),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)).right(new TreeNode(3)),
                            new int[]{1, 2, 3}
                    ),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).left(new TreeNode(4)).right(new TreeNode(5))).right(new TreeNode(3)),
                            new int[] {1, 2, 3, 4, 5}
                    ),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).right(new TreeNode(4))).right(new TreeNode(3).right(new TreeNode(5))),
                            new int[] {1, 2, 3, 4, 5}
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    void levelOrder(TreeNode tree, int[] expected) {
        assertArrayEquals(expected, test.levelOrder(tree));
    }
}