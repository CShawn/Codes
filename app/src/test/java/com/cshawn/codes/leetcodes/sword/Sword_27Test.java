package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @Date 2020/12/10 22:20
 */
class Sword_27Test {
    private final Sword_27 test = new Sword_27();

    static class TreeNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((TreeNode)null, (TreeNode)null),
                    Arguments.of(new TreeNode(1), new TreeNode(1)),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)),
                            new TreeNode(1).right(new TreeNode(2))),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).left(new TreeNode(4)).right(new TreeNode(5))).right(new TreeNode(3)),
                            new TreeNode(1).right(new TreeNode(2).right(new TreeNode(4)).left(new TreeNode(5))).left(new TreeNode(3))
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    void mirrorTree(TreeNode origin, TreeNode mirror) {
        assertEquals(mirror, test.mirrorTree(origin));
    }
}