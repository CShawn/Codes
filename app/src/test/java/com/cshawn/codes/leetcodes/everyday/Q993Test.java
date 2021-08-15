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
 * @date 2021/5/17 5:25 下午
 */
class Q993Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new TreeNode(new Integer[]{1,2,3,4}), 4, 3, false),
                    Arguments.of(new TreeNode(new Integer[]{1,2,3,null,4}), 2, 3, false),
                    Arguments.of(new TreeNode(new Integer[]{1,2,3,null,4,null,5}), 5, 4, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isCousins(TreeNode root, int x, int y, boolean result) {
        Assertions.assertEquals(result, new Q993().isCousins(root, x, y));
    }
}