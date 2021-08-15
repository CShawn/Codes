package com.cshawn.codes.leetcodes.sword;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cshawn.codes.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

/**
 * @author C.Shawn
 * @date 2020/11/15 20:11
 */
public class Sword_6Test {

    public static class ListNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                Arguments.of((ListNode)null, ""),
                Arguments.of(new ListNode(1), "1"),
                Arguments.of(new ListNode(1).next(1), "11"),
                Arguments.of(new ListNode(1).next(2).next(3), "321"),
                Arguments.of(new ListNode(1).next(2).next(3).next(4), "4321")
            );
        }
    }

    private Sword_6 test = new Sword_6();

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    public void reversePrint(ListNode head, String expected) {
        assertEquals(expected, arrayToString(test.reversePrint(head)));
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}