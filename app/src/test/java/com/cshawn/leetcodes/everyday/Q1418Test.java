package com.cshawn.leetcodes.everyday;

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
 * @date 2021/7/6 9:43 上午
 */
class Q1418Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(
                            new String[][]{{"David","3","Ceviche"},{"Corina","10","Beef Burrito"},{"David","3","Fried Chicken"},{"Carla","5","Water"},{"Carla","5","Ceviche"},{"Rous","3","Ceviche"}},
                            new String[][]{{"Table","Beef Burrito","Ceviche","Fried Chicken","Water"},{"3","0","2","1","0"},{"5","0","1","0","1"},{"10","1","0","0","0"}}
                    ),
                    Arguments.of(
                            new String[][]{{"James","12","Fried Chicken"},{"Ratesh","12","Fried Chicken"},{"Amadeus","12","Fried Chicken"},{"Adam","1","Canadian Waffles"},{"Brianna","1","Canadian Waffles"}},
                            new String[][]{{"Table","Canadian Waffles","Fried Chicken"},{"1","2","0"},{"12","0","3"}}
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void displayTable(String[][] orders, String[][] result) {
        List<List<String>> list = new ArrayList<>(orders.length);
        for (String[] order : orders) {
            list.add(Arrays.asList(order));
        }
        List<List<String>> res = new Q1418().displayTable(list);
        String[][] r = new String[res.size()][res.get(0).size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i).toArray(new String[0]);
        }
        Assertions.assertArrayEquals(result, r);
    }
}