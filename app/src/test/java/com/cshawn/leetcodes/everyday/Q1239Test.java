package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/6/19 10:29 上午
 */
class Q1239Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
//                    Arguments.of(new String[]{"un","iq","ue"}, 4),
//                    Arguments.of(new String[]{"cha","r","act","ers"}, 6),
//                    Arguments.of(new String[]{"abcdefghijklmnopqrstuvwxyz"}, 26),
//                    Arguments.of(new String[]{"aa", "b"}, 1),
//                    Arguments.of(new String[]{"aa", "bb"}, 0),
                    Arguments.of(new String[]{"un","iq","ue", "wdsjkl", "sdk"}, 10)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxLength(String[] arr, int result) {
        Assertions.assertEquals(result, new Q1239().maxLength(Arrays.asList(arr)));
    }
}