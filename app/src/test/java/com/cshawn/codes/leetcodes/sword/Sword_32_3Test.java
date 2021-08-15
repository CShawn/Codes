package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2020/12/16 3:08 下午
 */
class Sword_32_3Test {
    private final Sword_32_3 test = new Sword_32_3();

    static class TreeNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((TreeNode)null, new ArrayList<List<Integer>>()),
                    Arguments.of(new TreeNode(1), new ArrayList<List<Integer>>(){{add(new ArrayList<Integer>(){{add(1);}});}}),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2)).right(new TreeNode(3)),
                            new ArrayList<List<Integer>>(){{
                                add(new ArrayList<Integer>(){{add(1);}});
                                add(new ArrayList<Integer>(){{
                                    add(3);
                                    add(2);
                                }});
                            }}
                    ),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).left(new TreeNode(4)).right(new TreeNode(5))).right(new TreeNode(3)),
                            new ArrayList<List<Integer>>(){{
                                add(new ArrayList<Integer>(){{add(1);}});
                                add(new ArrayList<Integer>(){{
                                    add(3);
                                    add(2);
                                }});
                                add(new ArrayList<Integer>(){{
                                    add(4);
                                    add(5);
                                }});
                            }}
                    ),
                    Arguments.of(new TreeNode(1).left(new TreeNode(2).right(new TreeNode(4))).right(new TreeNode(3).right(new TreeNode(5))),
                            new ArrayList<List<Integer>>(){{
                                add(new ArrayList<Integer>(){{add(1);}});
                                add(new ArrayList<Integer>(){{
                                    add(3);
                                    add(2);
                                }});
                                add(new ArrayList<Integer>(){{
                                    add(4);
                                    add(5);
                                }});
                            }}
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TreeNodeArgumentsProvider.class)
    void levelOrder(TreeNode root, ArrayList<List<Integer>> expected) {
        assertArrayEquals(expected.toArray(), test.levelOrder(root).toArray());
    }
}