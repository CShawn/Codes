package com.cshawn.codes.leetcodes.crack;

import java.util.stream.Stream;


import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * @author C.Shawn
 * @date 2021/3/16 21:51
 */
public class Q4_12Test {
    
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(null, 1, 0),
                    Arguments.of(new TreeNode(1), 2, 0),
                    Arguments.of(new TreeNode(1).left(2), 2, 1),
                    Arguments.of(new TreeNode(1).left(2), 1, 1),
                    Arguments.of(new TreeNode(1).left(2), 3, 1),
                    Arguments.of(new TreeNode(5).left(new TreeNode(4).left(new TreeNode(11).left(7).right(2)))
                    .right(new TreeNode(8).left(13).right(new TreeNode(4).left(5).right(1))), 22, 3),
                    Arguments.of(new TreeNode(5).left(new TreeNode(4).left(new TreeNode(11).left(7).right(2)))
                    .right(new TreeNode(8).left(13).right(new TreeNode(4).left(5).right(1))), 13, 4)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void checkSubTree(TreeNode t, int sum, int result) {
        Assertions.assertEquals(result, new Q4_12().pathSum(t, sum));
    }
}
