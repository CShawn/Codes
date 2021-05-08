package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/5/8 10:07 下午
 */
class Q1723Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,2,3}, 3, 3),
                    Arguments.of(new int[]{1,2,4,7,8}, 2, 11),
                    Arguments.of(new int[]{254,256,256,254,251,256,254,253,255,251,251,255}, 10, 504)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minimumTimeRequired(int[] jobs, int k, int result) {
//        Assertions.assertEquals(result, new Q1723().minimumTimeRequired1(jobs, k));
        Assertions.assertEquals(result, new Q1723().minimumTimeRequired(jobs, k));
    }
}