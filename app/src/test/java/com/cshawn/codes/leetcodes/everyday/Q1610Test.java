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
 * @date 2021/12/16 11:20 上午
 */
class Q1610Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Integer[][]{{1,1},{1,1},{1,1}}, 1, new Integer[]{1,1}, 3),
                    Arguments.of(new Integer[][]{{2,1},{2,2},{3,3}}, 90, new Integer[]{1,1}, 3),
                    Arguments.of(new Integer[][]{{2,1},{2,2},{3,4},{1,1}}, 90, new Integer[]{1,1}, 4),
                    Arguments.of(new Integer[][]{{1,0},{2,1}}, 13, new Integer[]{1,1}, 1),
                    Arguments.of(new Integer[][]{{1,0},{2,1},{1,1},{1,1}}, 13, new Integer[]{1,1}, 3),
                    Arguments.of(new Integer[][]{{1,1},{2,2},{3,3},{3,3},{3,4},{4,3},{4,4}}, 38, new Integer[]{3,3}, 4),
                    Arguments.of(new Integer[][]{{1,1},{2,2},{2,3},{2,4},{3,3},{3,2},{3,1},{3,3},{3,4},{4,2},{4,3},{4,4}}, 50, new Integer[]{3,3}, 6),
                    Arguments.of(new Integer[][]{{2,1},{2,2},{3,3},{1,1},{1,1},{6,3},{4,4},{2,3},{80,21},{23,33},{3,5},{9,6},{2,4},{4,2},{2,5}}, 38, new Integer[]{3,3}, 5),
                    Arguments.of(new Integer[][]{{60,61},{58,47},{17,26},{87,97},{63,63},{26,50},{70,21},{3,89},{51,24},{55,14},{6,51},{64,21},{66,33},{54,35},{87,38},{30,0},{37,92},{92,12},{60,73},{75,98},{1,11},{88,24},{82,92}}, 44, new Integer[]{15,50}, 11)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void visiblePoints(Integer[][] points, int angle, Integer[] location, int result) {
        List<List<Integer>> list = new ArrayList<>();
        for (Integer[] point : points) {
            List<Integer> pL = new ArrayList<>();
            for (Integer p : point) {
                pL.add(p);
            }
            list.add(pL);
        }
        assertEquals(result, new Q1610().visiblePoints(list, angle, Arrays.asList(location)));
        assertEquals(result, new Q1610().visiblePoints1(list, angle, Arrays.asList(location)));
    }
}