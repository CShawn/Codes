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
 * @date 2021/6/6 22:16
 */
public class Q474Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new String[0], 2, 4, 0),
                    Arguments.arguments(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3, 4),
                    Arguments.arguments(new String[]{"10", "0", "1"}, 1, 1, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findMaxForm(String[] strs, int m, int n, int result) {
        Assertions.assertEquals(result, new Q474().findMaxForm1(strs, m, n));
        Assertions.assertEquals(result, new Q474().findMaxForm2(strs, m, n));
        Assertions.assertEquals(result, new Q474().findMaxForm(strs, m, n));
    }
}
