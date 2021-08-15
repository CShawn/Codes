package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2020/12/23 8:37 下午
 */
class Sword_36Test {
    private final Sword_36 test = new Sword_36();

    static class NodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((Sword_36.Node)null, 1, new Integer[0], new Integer[0]),
                    Arguments.of(new Sword_36.Node(1), 1, new Integer[]{1}, new Integer[]{1}),
                    Arguments.of(new Sword_36.Node(1), 2, new Integer[]{1, 1}, new Integer[]{1, 1}),
                    Arguments.of(new Sword_36.Node(1).right(new Sword_36.Node(2)), 2, new Integer[]{1, 2}, new Integer[]{1, 2}),
                    Arguments.of(new Sword_36.Node(1).right(new Sword_36.Node(2)), 4, new Integer[]{1, 2, 1, 2}, new Integer[]{1, 2, 1, 2}),
                    Arguments.of(new Sword_36.Node(2).left(new Sword_36.Node(1)), 4, new Integer[]{1, 2, 1, 2}, new Integer[]{1, 2, 1, 2}),
                    Arguments.of(new Sword_36.Node(4).left(
                            new Sword_36.Node(2).left(
                                    new Sword_36.Node(1)
                            ).right(new Sword_36.Node(3))
                            ).right(new Sword_36.Node(5)
                                    .right(new Sword_36.Node(6))
                            ),
                            6,
                            new Integer[]{1,6,5,4,3,2},
                            new Integer[]{1,2,3,4,5,6}
                    ),
                    Arguments.of(new Sword_36.Node(4).left(
                            new Sword_36.Node(2).left(
                                    new Sword_36.Node(1)
                            ).right(new Sword_36.Node(3))
                            ).right(new Sword_36.Node(5)
                                    .right(new Sword_36.Node(6))
                            ),
                            12,
                            new Integer[]{1,6,5,4,3,2,1,6,5,4,3,2},
                            new Integer[]{1,2,3,4,5,6,1,2,3,4,5,6}
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(NodeArgumentsProvider.class)
    void treeToDoublyListLeft(Sword_36.Node node, int size, Integer[] left, Integer[] right) {
        if (node == null) {
            assertEquals(0, left.length);
            assertEquals(0, right.length);
        } else {
            assertArrayEquals(left, test.treeToDoublyList(node).toLeft(size).toArray());
        }
    }

    @ParameterizedTest
    @ArgumentsSource(NodeArgumentsProvider.class)
    void treeToDoublyListLeft2(Sword_36.Node node, int size, Integer[] left, Integer[] right) {
        if (node == null) {
            assertEquals(0, left.length);
            assertEquals(0, right.length);
        } else {
            assertArrayEquals(left, test.treeToDoublyList2(node).toLeft(size).toArray());
        }
    }

    @ParameterizedTest
    @ArgumentsSource(NodeArgumentsProvider.class)
    void treeToDoublyListRight(Sword_36.Node node, int size, Integer[] left, Integer[] right) {
        if (node == null) {
            assertEquals(0, left.length);
            assertEquals(0, right.length);
        } else {
            assertArrayEquals(right, test.treeToDoublyList(node).toRight(size).toArray());
        }
    }

    @ParameterizedTest
    @ArgumentsSource(NodeArgumentsProvider.class)
    void treeToDoublyListRight2(Sword_36.Node node, int size, Integer[] left, Integer[] right) {
        if (node == null) {
            assertEquals(0, left.length);
            assertEquals(0, right.length);
        } else {
            assertArrayEquals(right, test.treeToDoublyList2(node).toRight(size).toArray());
        }
    }
}