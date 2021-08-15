package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/7/22 9:07 上午
 */
class Q138Test {
    private final Q138 test = new Q138();

    static class NodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            Q138.Node one = new Q138.Node(1);
            Q138.Node one2 = new Q138.Node(1).order(4);
            Q138.Node three = new Q138.Node(3).random(one);
            Q138.Node seven = new Q138.Node(7);
            Q138.Node eleven = new Q138.Node(11);
            return Stream.of(
//                    Arguments.of(null, new Integer[0][0]),
//                    Arguments.of(new Q138.Node(1), new Integer[][] {new Integer[]{1, null}}),
                    Arguments.of(one.next(new Q138.Node(2).order(1).next(three.order(2))).random(three), new Integer[][] {new Integer[]{1, 2}, new Integer[]{2, null}, new Integer[]{3, 0}}),
                    Arguments.of(
                            seven.next(new Q138.Node(13).order(1).random(seven)
                                    .next(eleven.order(2).random(one2)
                                            .next(new Q138.Node(10).order(3).random(eleven)
                                                    .next(one2.random(seven))))),
                            new Integer[][]{{7,null},{13,0},{11,4},{10,2},{1,0}}
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(NodeArgumentsProvider.class)
    void copyRandomList(Q138.Node node, Integer[][] expected) {
        if (node == null) {
            assertEquals(0, expected.length);
        } else {
            assertArrayEquals(expected, test.copyRandomList1(node).toArray().toArray());
            assertArrayEquals(expected, test.copyRandomList(node).toArray().toArray());
        }
    }
}