package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/10/16 5:09 下午
 */
class Q262Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("123", 6, new String[]{"1+2+3", "1*2*3"}),
                    Arguments.of("232", 8, new String[]{"2*3+2", "2+3*2"}),
                    Arguments.of("105", 5, new String[]{"1*0+5","10-5"}),
                    Arguments.of("00", 0, new String[]{"0+0", "0-0", "0*0"}),
                    Arguments.of("00", 0, new String[]{"0+0", "0-0", "0*0"}),
                    Arguments.of("3456237490", 9191, new String[0]),
                    Arguments.of("2147483648", -2147483648, new String[0]),
                    Arguments.of("50", 5, new String[]{"5+0", "5-0"}),
                    Arguments.of("5", 5, new String[]{"5"}),
                    Arguments.of("5", -5, new String[0]),
                    Arguments.of("50", 4, new String[0])
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void addOperators(String num, int target, String[] result) {
        Arrays.sort(result);
        Object[] res = new Q262().addOperators(num, target).toArray();
        Arrays.sort(res);
        Assertions.assertArrayEquals(result, res);
    }
}