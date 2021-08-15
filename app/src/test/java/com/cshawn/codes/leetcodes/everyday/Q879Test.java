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
 * @date 2021/5/10 9:23 下午
 */
public class Q879Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(5, 3, new int[]{2, 2}, new int[]{2, 3}, 2),
                    Arguments.of(10, 5, new int[]{2,3,5}, new int[]{6, 7, 8}, 7)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void profitableSchemes1(int n, int minProfit, int[] group, int[] profit, int result) {
        Assertions.assertEquals(result, new Q879().profitableSchemes(n, minProfit, group, profit));
    }
}
