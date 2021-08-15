package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/6/20 2:59 下午
 */
class Q1600Test {
    @Test
    void test() {
        Q1600.ThroneInheritance t = new Q1600.ThroneInheritance("king");
        t.birth("king", "andy"); // 继承顺序：king > andy
        Assertions.assertArrayEquals(new String[]{"king", "andy"}, t.getInheritanceOrder().toArray());
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        Assertions.assertArrayEquals(new String[]{"king", "andy", "bob"}, t.getInheritanceOrder().toArray());
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        Assertions.assertArrayEquals(new String[]{"king", "andy", "bob", "catherine"}, t.getInheritanceOrder().toArray());
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        Assertions.assertArrayEquals(new String[]{"king", "andy", "matthew", "bob", "catherine"}, t.getInheritanceOrder().toArray());
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        Assertions.assertArrayEquals(new String[]{"king", "andy", "matthew", "bob", "alex", "catherine"}, t.getInheritanceOrder().toArray());
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        Assertions.assertArrayEquals(new String[]{"king", "andy", "matthew", "bob", "alex", "asha", "catherine"}, t.getInheritanceOrder().toArray());
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        Assertions.assertArrayEquals(new String[]{"king", "andy", "matthew", "alex", "asha", "catherine"}, t.getInheritanceOrder().toArray());
    }
}