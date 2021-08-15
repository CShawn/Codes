package com.cshawn.codes;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2020/11/17 20:35
 */
public class TreeNodeArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
            Arguments.of((TreeNode)null, new int[0], new int[0], new int[0]),
            Arguments.of(new TreeNode(1), new int[]{1}, new int[]{1}, new int[]{1}),
            Arguments.of(
                new TreeNode(1).left(new TreeNode(2).left(new TreeNode(3))), 
                new int[]{1, 2, 3},
                new int[]{3, 2, 1},
                new int[]{3, 2, 1}
            ),
            Arguments.of(
                new TreeNode(1).right(new TreeNode(2).right(new TreeNode(3))), 
                new int[]{1, 2, 3},
                new int[]{1, 2, 3},
                new int[]{3, 2, 1}
            ),
            Arguments.of(
                new TreeNode(1).left(new TreeNode(2)).right(new TreeNode(3)), 
                new int[]{1, 2, 3},
                new int[]{2, 1, 3},
                new int[]{2, 3, 1}
            )
        );
    }
}