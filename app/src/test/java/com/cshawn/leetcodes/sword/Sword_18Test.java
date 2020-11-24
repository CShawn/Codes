package com.cshawn.leetcodes.sword;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

/**
 * @author C.Shawn
 * @Date 2020/11/24 23:03
 */
public class Sword_18Test {
    public static class ListNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                Arguments.of((ListNode)null, 1, (ListNode)null),
                Arguments.of(new ListNode(1), 1, (ListNode)null),
                Arguments.of(new ListNode(1).next(2), 1, new ListNode(2)),
                Arguments.of(new ListNode(1).next(2).next(3), 2, new ListNode(1).next(3)),
                Arguments.of(new ListNode(1).next(2).next(3), 4, new ListNode(1).next(2).next(3))
            );
        }
    }

    private Sword_18 test = new Sword_18();

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    public void reversePrint(ListNode head, int val, ListNode expected){
        assertEquals(expected, test.deleteNode(head, val));
    }
}
