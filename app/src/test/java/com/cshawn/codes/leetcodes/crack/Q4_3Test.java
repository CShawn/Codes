package com.cshawn.codes.leetcodes.crack;

import com.cshawn.codes.ListNode;
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
 * @date 2021/3/5 10:30 下午
 */
class Q4_3Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            TreeNode one = new TreeNode(1);
            return Stream.of(
                    Arguments.of(null, new int[0][0]),
                    Arguments.of(new TreeNode(1)
                            .left(new TreeNode(2).left(new TreeNode(4)))
                            .right(new TreeNode(3).right(new TreeNode(7))),
                            new int[][]{new int[]{1}, new int[]{2, 3}, new int[]{4, 7}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void listOfDepth1(TreeNode tree, int[][] result) {
        ListNode[] nodes = new Q4_3().listOfDepth1(tree);
        int[][] list2 = new int[nodes.length][];
        for (int i = 0; i < nodes.length; i++) {
            list2[i] = nodes[i].toArray();
        }
        Assertions.assertArrayEquals(result, list2);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void listOfDepth(TreeNode tree, int[][] result) {
        ListNode[] nodes = new Q4_3().listOfDepth(tree);
        int[][] list2 = new int[nodes.length][];
        for (int i = 0; i < nodes.length; i++) {
            list2[i] = nodes[i].toArray();
        }
        Assertions.assertArrayEquals(result, list2);
    }
}