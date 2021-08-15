package com.cshawn.codes.leetcodes.everyday;


import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/7/31 10:49 上午
 */
class Q987Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Integer[]{3,9,20,null,null,15,7}, new Integer[][]{{9},{3,15},{20},{7}}),
                    Arguments.of(new Integer[]{1,2,3,4,5,6,7}, new Integer[][]{{4},{2},{1,5,6},{3},{7}}),
                    Arguments.of(new Integer[]{1,2,3,4,6,5,7}, new Integer[][]{{4},{2},{1,5,6},{3},{7}}),
                    Arguments.of(new Integer[]{3,1,4,0,2,2}, new Integer[][]{{0},{1},{3,2,2},{4}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void verticalTraversal1(Integer[] tree, Integer[][] result) {
        List<List<Integer>> list = new Q987().verticalTraversal1(new TreeNode(tree));
        Integer[][] arr = new Integer[list.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, arr);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void verticalTraversal(Integer[] tree, Integer[][] result) {
        List<List<Integer>> list = new Q987().verticalTraversal(new TreeNode(tree));
        Integer[][] arr = new Integer[list.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i).toArray(new Integer[0]);
        }
        Assertions.assertArrayEquals(result, arr);
    }
}