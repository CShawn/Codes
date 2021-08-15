package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @Date 2020/12/10 21:23
 */
public class Sword_26Test {
    private final Sword_26 test = new Sword_26();

    static class TreeNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((TreeNode)null, (TreeNode)null, false),
                    Arguments.of(new TreeNode(1), (TreeNode)null, false),
                    Arguments.of((TreeNode)null, new TreeNode(1), false),
                    Arguments.of(new TreeNode(1), new TreeNode(1), true),
                    Arguments.of(
                            new TreeNode(1).left(new TreeNode(2).left(new TreeNode(3))),
                            new TreeNode(1).left(new TreeNode(2)),
                            true
                    ),
                    Arguments.of(
                            new TreeNode(1).left(new TreeNode(2).left(new TreeNode(3))),
                            new TreeNode(2).left(new TreeNode(3)),
                            true
                    ),
                    Arguments.of(
                            new TreeNode(1).left(new TreeNode(2).left(new TreeNode(3))),
                            new TreeNode(1).right(new TreeNode(3)),
                            false
                    ),
                    Arguments.of(
                            new TreeNode(1).left(new TreeNode(2).left(new TreeNode(3))),
                            new TreeNode(2).right(new TreeNode(3)),
                            false
                    ),
                    Arguments.of(
                            new TreeNode(1).left(new TreeNode(2).right(new TreeNode(3))),
                            new TreeNode(2).right(new TreeNode(3)),
                            true
                    ),
                    Arguments.of(
                            new TreeNode(1).right(new TreeNode(2).right(new TreeNode(3))),
                            new TreeNode(1).right(new TreeNode(2)),
                            true
                    ),
                    Arguments.of(
                            new TreeNode(1).right(new TreeNode(2).right(new TreeNode(3))),
                            new TreeNode(2),
                            true
                    ),
                    Arguments.of(
                            new TreeNode(1).right(new TreeNode(2).right(new TreeNode(3))),
                            new TreeNode(3),
                            true
                    ),
                    Arguments.of(
                            new TreeNode(1).left(new TreeNode(2)).right(new TreeNode(1).left(new TreeNode(3))),
                            new TreeNode(1).left(new TreeNode(3)),
                            true
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    public void isSubStructure(TreeNode target, TreeNode pattern, boolean isSub) {
        assertEquals(isSub, test.isSubStructure(target, pattern));
    }
}
