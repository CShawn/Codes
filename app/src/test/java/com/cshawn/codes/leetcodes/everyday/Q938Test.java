package com.cshawn.codes.leetcodes.everyday;


import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/4/27 6:54 下午
 */
class Q938Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Integer[]{10,5,15,3,7,null,18}, 7, 15, 32),
                    Arguments.of(new Integer[]{10,5,15,3,7,13,18,1,null,6}, 6, 10, 23),
                    Arguments.of(new Integer[]{2,1,3}, 4, 10, 0),
                    Arguments.of(new Integer[]{2,1,3}, 0, 10, 6),
                    Arguments.of(new Integer[]{2,1,3}, 2, 10, 5),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 10, 34),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 1, 10, 34),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 2, 10, 33),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 3, 10, 33),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 4, 10, 30),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 5, 10, 26),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 6, 10, 21),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 7, 10, 15),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 8, 10, 8),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 9, 10, 0),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 0, 0),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 1, 1),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 2, 1),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 3, 4),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 4, 8),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 5, 13),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 6, 19),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 7, 26),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 8, 34),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 0, 9, 34),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 3, 8, 33),
                    Arguments.of(new Integer[]{5,3,7,1,4,6,8}, 4, 7, 22)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void rangeSumBST(Integer[] tree, int low, int height, int result) {
        Assertions.assertEquals(result, new Q938().rangeSumBST(new TreeNode(tree), low, height));
    }
}