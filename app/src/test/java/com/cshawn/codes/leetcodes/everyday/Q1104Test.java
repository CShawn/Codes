package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/7/29 5:50 下午
 */
class Q1104Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(1, new Integer[]{1}),
                    Arguments.of(2, new Integer[]{1,2}),
                    Arguments.of(14, new Integer[]{1,3,4,14}),
                    Arguments.of(26, new Integer[]{1,2,6,10,26})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void pathInZigZagTree(int label, Integer[] result) {
        Assertions.assertArrayEquals(result, new Q1104().pathInZigZagTree1(label).toArray());
        Assertions.assertArrayEquals(result, new Q1104().pathInZigZagTree(label).toArray());
    }
}