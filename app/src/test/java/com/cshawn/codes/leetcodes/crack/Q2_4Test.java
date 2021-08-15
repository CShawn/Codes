package com.cshawn.codes.leetcodes.crack;

import com.cshawn.codes.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/2/25 10:10 下午
 */
class Q2_4Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, 4),
                    Arguments.of(new ListNode(1), 4),
                    Arguments.of(new ListNode(4), 4),
                    Arguments.of(new ListNode(1).next(1), 4),
                    Arguments.of(new ListNode(0).next(5).next(3).next(4), 4),
                    Arguments.of(new ListNode(5).next(6).next(6).next(8), 5),
                    Arguments.of(new ListNode(9).next(6).next(6).next(8), 7),
                    Arguments.of(new ListNode(1).next(4).next(3).next(2).next(5), 3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void partition1(ListNode head, int x) {
        ListNode result = new Q2_4().partition1(head, x);
        boolean flag = false;
        boolean match = true;
        while (result != null) {
            if (flag) {
                if (result.val < x) {
                    match = false;
                    break;
                }
            } else if (result.val >= x) {
                flag = true;
            }
            result = result.next;
        }
        Assertions.assertTrue(match);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void partition(ListNode head, int x) {
        ListNode result = new Q2_4().partition(head, x);
        boolean flag = false;
        boolean match = true;
        while (result != null) {
            if (flag) {
                if (result.val < x) {
                    match = false;
                    break;
                }
            } else if (result.val >= x) {
                flag = true;
            }
            result = result.next;
        }
        Assertions.assertTrue(match);
    }
}