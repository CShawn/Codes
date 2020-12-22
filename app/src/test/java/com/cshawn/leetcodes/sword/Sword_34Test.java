package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2020/12/21 11:18 下午
 */
class Sword_34Test {
    private final Sword_34 test = new Sword_34();

    static class TreeNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((TreeNode)null, 1, new int[0][0]),
                    Arguments.of(new TreeNode(1), 1, new int[][] {new int[]{1}}),
                    Arguments.of(new TreeNode(1), 2, new int[0][0]),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)), 1, new int[0][0]),
                    Arguments.of(new TreeNode(-2).right(new TreeNode(-3)), -5, new int[][]{new int[]{-2, -3}}),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)).right(new TreeNode(3)),
                            3,
                            new int[][] {new int[]{1, 2}}
                    ),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).left(new TreeNode(4)).right(new TreeNode(5))).right(new TreeNode(3)),
                            8,
                            new int[][] {new int[] {1, 2, 5}}
                    ),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).right(new TreeNode(4))).right(new TreeNode(3).right(new TreeNode(3))),
                            7,
                            new int[][] {new int[]{1, 2, 4}, new int[]{1, 3, 3}}
                    ),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).right(new TreeNode(4))).right(new TreeNode(3).right(new TreeNode(3))),
                            8,
                            new int[0][0]
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    void pathSum(TreeNode tree, int sum, int[][] path) {
        List<List<Integer>> list = test.pathSum(tree, sum);
        assertEquals(path.length, list.size());
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                assertEquals(path[i][j], list.get(i).get(j));
            }
        }
    }
}