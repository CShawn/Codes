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
 * @date 2020/12/22 8:38 下午
 */
class Sword_35Test {
    private final Sword_35 test = new Sword_35();

    static class NodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            Sword_35.Node one = new Sword_35.Node(1);
            Sword_35.Node one2 = new Sword_35.Node(1).order(4);
            Sword_35.Node three = new Sword_35.Node(3).random(one);
            Sword_35.Node seven = new Sword_35.Node(7);
            Sword_35.Node eleven = new Sword_35.Node(11);
            return Stream.of(
                    Arguments.of((Sword_35.Node)null, new Integer[0][0]),
                    Arguments.of(new Sword_35.Node(1), new Integer[][] {new Integer[]{1, null}}),
                    Arguments.of(one.next(new Sword_35.Node(2).order(1).next(three.order(2))).random(three), new Integer[][] {new Integer[]{1, 2}, new Integer[]{2, null}, new Integer[]{3, 0}}),
                    Arguments.of(
                            seven.next(new Sword_35.Node(13).order(1).random(seven)
                            .next(eleven.order(2).random(one2)
                            .next(new Sword_35.Node(10).order(3).random(eleven)
                            .next(one2.random(seven))))),
                            new Integer[][]{{7,null},{13,0},{11,4},{10,2},{1,0}}
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(NodeArgumentsProvider.class)
    void copyRandomList(Sword_35.Node node, Integer[][] expected) {
        if (node == null) {
            assertEquals(0, expected.length);
        } else {
            assertArrayEquals(expected, test.copyRandomList(node).toArray().toArray());
            assertArrayEquals(expected, test.copyRandomList2(node).toArray().toArray());
        }
    }
}