package com.cshawn.leetcodes.crack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/3/28 8:14 下午
 */
class Q8_6Test {

    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new ArrayList<Integer>() {{add(3);add(2);add(1);}}, new ArrayList<Integer>(), new ArrayList<Integer>()),
                    Arguments.arguments(new ArrayList<Integer>() {{add(5);add(4);add(3);add(2);add(1);}}, new ArrayList<Integer>(), new ArrayList<Integer>())
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int[] a = A.stream().mapToInt(Integer::intValue).toArray();
        new Q8_6().hanota(A, B, C);
        int[] c = C.stream().mapToInt(Integer::intValue).toArray();
        Assertions.assertArrayEquals(a, c);
    }
}