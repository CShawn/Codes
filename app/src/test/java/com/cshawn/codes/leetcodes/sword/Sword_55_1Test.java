package com.cshawn.codes.leetcodes.sword;

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
 * @date 2021/1/23 9:23 下午
 */
class Sword_55_1Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new TreeNode(1), 1),
                    Arguments.of(new TreeNode(2).left(new TreeNode(1)), 2),
                    Arguments.of(new TreeNode(2).right(new TreeNode(3)), 2),
                    Arguments.of(new TreeNode(2).left(new TreeNode(1)).right(new TreeNode(3)), 2),
                    Arguments.of(new TreeNode(1).right(new TreeNode(2).right(new TreeNode(3))), 3),
                    Arguments.of(new TreeNode(3).left(new TreeNode(2).left(new TreeNode(1))), 3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxDepth(TreeNode tree, int depth) {
        Assertions.assertEquals(depth, new Sword_55_1().maxDepth(tree));
    }
}