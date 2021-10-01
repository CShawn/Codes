package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/10/1 9:01 上午
 */
class Q1436Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[][]{{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}}, "Sao Paulo"),
                    Arguments.of(new String[][]{{"B","C"},{"D","B"},{"C","A"}}, "A")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void destCity(String[][] paths, String result) {
        List<List<String>> list = new ArrayList<>(paths.length);
        for (String[] path : paths) {
            List<String> l = new ArrayList<>(2);
            l.addAll(Arrays.asList(path));
            list.add(l);
        }
        assertEquals(result, new Q1436().destCity1(list));
        assertEquals(result, new Q1436().destCity(list));
    }
}