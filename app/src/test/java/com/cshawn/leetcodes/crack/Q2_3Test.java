package com.cshawn.leetcodes.crack;

import com.cshawn.leetcodes.sword.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/2/25 8:18 下午
 */
class Q2_3Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            return Stream.of(
                    Arguments.of(new ListNode(0).next(node1).next(3), node1, new int[]{0,3}),
                    Arguments.of(new ListNode(1).next(node2).next(3).next(4), node2, new int[]{1,3,4})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void deleteNode(ListNode head, ListNode node, int[] result) {
        new Q2_3().deleteNode(node);
        Assertions.assertArrayEquals(result, head.toArray());
    }
}