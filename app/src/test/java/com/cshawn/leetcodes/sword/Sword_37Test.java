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
 * @date 2020/12/28 9:46 下午
 */
class Sword_37Test {
    private final Sword_37 test = new Sword_37();

    static class TreeNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((TreeNode)null, "[]"),
                    Arguments.of(new TreeNode(1), "[1,null,null]"),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)), "[1,2,null,null,null]"),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)).right(new TreeNode(3)),
                            "[1,2,3,null,null,null,null]"
                    ),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).left(new TreeNode(4)).right(new TreeNode(5))).right(new TreeNode(3)),
                            "[1,2,3,4,5,null,null,null,null,null,null]"
                    ),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).right(new TreeNode(5))).right(new TreeNode(3).right(new TreeNode(7))),
                            "[1,2,3,null,5,null,7,null,null,null,null]"
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    void serialize(TreeNode node, String expected) {
        assertEquals(expected, test.serialize(node));
    }

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    void deserialize(TreeNode node, String str) {
        assertEquals(node, test.deserialize(str));
    }
}