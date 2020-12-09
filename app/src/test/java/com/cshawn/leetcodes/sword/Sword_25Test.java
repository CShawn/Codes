package com.cshawn.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * @author C.Shawn
 * @Date 2020/12/09 20:21
 */
public class Sword_25Test {
    private final Sword_25 test = new Sword_25();

    public static class ListNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                Arguments.of((ListNode)null, (ListNode)null, (ListNode)null),
                Arguments.of(new ListNode(1), null, new ListNode(1)),
                Arguments.of(null, new ListNode(1), new ListNode(1)),
                Arguments.of(new ListNode(1).next(2).next(3), new ListNode(4).next(5).next(6), new ListNode(1).next(2).next(3).next(4).next(5).next(6)),
                Arguments.of(new ListNode(1).next(4).next(5), new ListNode(2).next(3).next(6), new ListNode(1).next(2).next(3).next(4).next(5).next(6))
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    public void mergeTwoLists(ListNode l1, ListNode l2, ListNode expected) {
        assertEquals(expected, test.mergeTwoLists(l1, l2));
    }
}
