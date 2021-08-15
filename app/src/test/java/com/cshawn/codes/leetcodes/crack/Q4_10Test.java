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
 * @date 2021/3/16 4:58 下午
 */
class Q4_10Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            TreeNode one = new TreeNode(1);
            return Stream.of(
                    Arguments.of(null, null, true),
                    Arguments.of(one, one, true),
                    Arguments.of(new TreeNode(1), one, false),
                    Arguments.of(new TreeNode(1).left(one), one, true),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)).right(one), one, true)
            );
        }
    }

    public static class DataArgumentsProvider2 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, null, true),
                    Arguments.of(new TreeNode(1), new TreeNode(1), true),
                    Arguments.of(new TreeNode(1).left(2), new TreeNode(2), true),
                    Arguments.of(new TreeNode(1).left(2).right(3), new TreeNode(3), true),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).right(4)).right(3), new TreeNode(2).right(4), true),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).right(new TreeNode(4).left(5))).right(new TreeNode(3).right(new TreeNode(2).right(4))), new TreeNode(2).right(4), true),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).right(new TreeNode(4))).right(new TreeNode(3).right(new TreeNode(2).right(4).left(5))), new TreeNode(2).right(4).left(5), true),
                    Arguments.of(new TreeNode(1).left(2).right(3), new TreeNode(4), false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void checkSubTree1(TreeNode t1, TreeNode t2, boolean result) {
        Assertions.assertEquals(result, new Q4_10().checkSubTree1(t1, t2));
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider2.class)
    void checkSubTree(TreeNode t1, TreeNode t2, boolean result) {
        Assertions.assertEquals(result, new Q4_10().checkSubTree(t1, t2));
    }
}