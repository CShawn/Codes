package com.cshawn.codes.leetcodes.crack;

import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/3/14 9:08 下午
 */
class Q4_9Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)).right(new TreeNode(3)),
                            new Integer[][]{new Integer[]{1,2,3}, new Integer[]{1,3,2}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void BSTSequences(TreeNode root, Integer[][] result) {
        List<List<Integer>> lists = new Q4_9().BSTSequences(root);
        Integer[][] res = new Integer[lists.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = lists.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, res);
    }
}