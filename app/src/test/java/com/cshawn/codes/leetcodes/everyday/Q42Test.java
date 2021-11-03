package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/11/3 5:42 下午
 */
class Q42Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6),
                    Arguments.of(new int[]{4,2,0,3,2,5}, 9)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void trap(int[] height, int result) {
        assertEquals(result, new Q42().trap1(height));
        assertEquals(result, new Q42().trap(height));
    }
}