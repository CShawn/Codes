package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/7/28 4:02 下午
 */
class Q863Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            TreeNode two = new TreeNode(2).left(7).right(4);
            TreeNode one = new TreeNode(5).left(6).right(two);
            TreeNode tree = new TreeNode(3).left(one).right(
                    new TreeNode(1).left(0).right(8)
            );
            return Stream.of(
                    Arguments.of(tree, one, 2, new Integer[]{1,4,7}),
                    Arguments.of(tree, one, 3, new Integer[]{0,8}),
                    Arguments.of(tree, two, 1, new Integer[]{4,5,7})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void distanceK(TreeNode root, TreeNode target, int k, Integer[] result) {
        Object[] res = new Q863().distanceK(root, target, k).toArray();
        Arrays.sort(res);
        Assertions.assertArrayEquals(result, res);
    }
}