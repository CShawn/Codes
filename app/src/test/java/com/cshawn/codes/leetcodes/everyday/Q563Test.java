package com.cshawn.codes.leetcodes.everyday;

import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/11/18 8:31 上午
 */
class Q563Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Integer[]{1,2,3}, 1),
                    Arguments.of(new Integer[]{4,2,9,3,5,null,7}, 15),
                    Arguments.of(new Integer[]{21,7,14,1,1,2,2,3,3}, 9)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findTilt(Integer[] nodes, int result) {
        assertEquals(result, new Q563().findTilt1(new TreeNode(nodes)));
        assertEquals(result, new Q563().findTilt(new TreeNode(nodes)));
    }
}