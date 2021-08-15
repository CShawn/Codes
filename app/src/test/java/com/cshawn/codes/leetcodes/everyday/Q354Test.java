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
 * @date 2021/3/4 4:55 下午
 */
class Q354Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, 0),
                    Arguments.of(new int[0][0], 0),
                    Arguments.of(new int[][]{new int[]{1,2}}, 1),
                    Arguments.of(new int[][]{new int[]{5,4}, new int[]{6,4}, new int[]{6,7}, new int[]{7,8}, new int[]{2,3}}, 4),
                    Arguments.of(new int[][]{new int[]{4,5}, new int[]{4,6}, new int[]{6,7}, new int[]{2,3}, new int[]{1,1}}, 4),
                    Arguments.of(new int[][]{new int[]{4,5}, new int[]{4,6}, new int[]{6,7}, new int[]{2,3}, new int[]{1,1}, new int[]{6,8}, new int[]{6,9}, new int[]{7,9}}, 5),
                    Arguments.of(new int[][]{new int[]{1,3}, new int[]{3,5}, new int[]{6,8}, new int[]{6,7}, new int[]{8,4}, new int[]{9,5}}, 3),
                    Arguments.of(new int[][]{new int[]{1,4}, new int[]{2,4}, new int[]{3,5}}, 2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void maxEnvelopes(int[][] envelopes, int result) {
        assertEquals(result, new Q354().maxEnvelopes1(envelopes));
        assertEquals(result, new Q354().maxEnvelopes(envelopes));
    }
}