package com.cshawn.leetcodes.crack;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
/**
 * @author C.Shawn
 * @date 2021/3/28 8:14 下午
 */
public class Q8_7Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments("", new String[]{""}),
                    Arguments.arguments("a", new String[]{"a"}),
                    Arguments.arguments("ab", new String[]{"ab", "ba"}),
                    Arguments.arguments("abc", new String[]{"abc", "acb", "bac", "bca", "cab", "cba"})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void permutation1(String s, String[] result) {
        String[] arr = new Q8_7().permutation1(s);
        Arrays.sort(arr);
        Assertions.assertArrayEquals(result, arr);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void permutation2(String s, String[] result) {
        String[] arr = new Q8_7().permutation2(s);
        Arrays.sort(arr);
        Assertions.assertArrayEquals(result, arr);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void permutation(String s, String[] result) {
        String[] arr = new Q8_7().permutation(s);
        Arrays.sort(arr);
        Assertions.assertArrayEquals(result, arr);
    }
}
