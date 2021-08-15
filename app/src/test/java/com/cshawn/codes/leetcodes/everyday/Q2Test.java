package com.cshawn.codes.leetcodes.everyday;


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
 * @date 2021/2/6 1:14 下午
 */
class Q2Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,4,3}, new int[]{5,6,4}, new int[]{7,0,8}),
                    Arguments.of(new int[]{2,4,3}, new int[0], new int[]{2,4,3}),
                    Arguments.of(new int[]{9,9,9,9,9,9,9}, new int[]{9,9,9,9}, new int[]{8,9,9,9,0,0,0,1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void addTwoNumbers(int[] l1, int[] l2, int[] sum) {
        Assertions.assertArrayEquals(sum, new Q2().addTwoNumbers(new ListNode(l1), new ListNode(l2)).toArray());
        Assertions.assertNull(new Q2().addTwoNumbers(null, null));
    }
}