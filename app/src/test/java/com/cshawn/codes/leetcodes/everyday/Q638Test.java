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
 * @date 2021/10/24 9:13 下午
 */
class Q638Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Integer[]{2,5},new Integer[][]{{3,0,5},{1,2,10}}, new Integer[]{3,2}, 14),
                    Arguments.of(new Integer[]{2,3,4},new Integer[][]{{1,1,0,4},{2,2,1,9}}, new Integer[]{1,2,1}, 11)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void shoppingOffers(Integer[] price, Integer[][] special, Integer[] needs, int result) {
        List<List<Integer>> specials = new ArrayList<>();
        for (Integer[] s : special) {
            specials.add(Arrays.asList(s));
        }
        Assertions.assertEquals(result, 
                new Q638().shoppingOffers(Arrays.asList(price), specials, Arrays.asList(needs)));
    }
}