package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/7/22 11:51 上午
 */
class Q120Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new Integer[][]{{2},{3,4},{6,5,7},{4,1,8,3}}, 11),
                    Arguments.arguments(new Integer[][]{{-5}}, -5),
                    Arguments.arguments(new Integer[][]{{-1},{-2,-3}}, -4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minimumTotal(Integer[][] triangle, int result) {
        List<List<Integer>> list = new ArrayList<>(triangle.length);
        for (int i = 0; i < triangle.length; i++) {
            list.add(i, Arrays.asList(triangle[i]));
        }
        Assertions.assertEquals(result, new Q120().minimumTotal1(list));
        Assertions.assertEquals(result, new Q120().minimumTotal2(list));
        Assertions.assertEquals(result, new Q120().minimumTotal3(list));
        Assertions.assertEquals(result, new Q120().minimumTotal(list));
    }
}