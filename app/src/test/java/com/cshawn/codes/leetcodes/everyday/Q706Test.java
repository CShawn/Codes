package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/3/14 9:52 上午
 */
class Q706Test {
    @Test
    void test() {
        Q706.MyHashMap test = new Q706().new MyHashMap();
        test.remove(27);
        test.put(65, 65);
        test.remove(19);
        test.remove(0);
        Assertions.assertEquals(-1, test.get(18));
        test.remove(3);
        test.put(42, 0);
        Assertions.assertEquals(-1, test.get(19));
        test.remove(42);
        test.put(17, 90);
        test.put(31, 76);
        test.put(48, 71);
        test.put(5, 50);
        test.put(7, 68);
        test.put(73, 74);
        test.put(85, 18);
        test.put(74, 95);
        test.put(84, 82);
        test.put(59, 29);
        test.put(71, 71);
        test.remove(42);
        test.put(51, 40);
        test.put(33, 76);
        Assertions.assertEquals(90, test.get(17));
        test.put(89, 95);
        Assertions.assertEquals(-1, test.get(95));
        test.put(30, 31);
        test.put(37, 99);
        Assertions.assertEquals(40, test.get(51));
        test.put(95, 35);
        test.remove(65);
        test.remove(81);
        test.put(61, 46);
        test.put(50, 33);
        Assertions.assertEquals(29, test.get(59));

        test.remove(5);
        test.put(75, 89);
        test.put(80, 17);
        test.put(35, 94);
        Assertions.assertEquals(17, test.get(80));
        test.put(19, 68);
        test.put(13, 17);
        test.remove(70);
        test.put(28, 35);
        test.remove(99);
        test.remove(37);
        test.remove(13);
        test.put(90, 83);
        test.remove(41);
        Assertions.assertEquals(33, test.get(50));
        test.put(29, 98);
        test.put(54, 72);
        test.put(6, 8);
        test.put(51, 88);
        test.remove(13);
        test.put(8, 22);
        Assertions.assertEquals(18, test.get(85));
        test.put(31, 22);
        test.put(60, 9);
        Assertions.assertEquals(-1, test.get(96));
        test.put(6, 35);
        test.remove(54);
        Assertions.assertEquals(-1, test.get(15));
        Assertions.assertEquals(35, test.get(28));
        test.remove(51);
        test.put(80, 69);
        test.put(58, 92);
        test.put(13, 12);
        test.put(91, 56);
        test.put(83, 52);
        test.put(8, 48);
        Assertions.assertEquals(-1, test.get(62));
        Assertions.assertEquals(-1, test.get(54));
        test.remove(25);
        test.put(36, 4);
        test.put(67, 68);
        test.put(83, 36);
        test.put(47, 58);
        Assertions.assertEquals(-1, test.get(82));
        test.remove(36);
        test.put(30, 85);
        test.put(33, 87);
        test.put(42, 18);
        test.put(68, 83);
        test.put(50, 53);
        test.put(32, 78);
        test.put(48, 90);
        test.put(97, 95);
        test.put(13, 8);
        test.put(15, 7);
        test.remove(5);
        test.remove(42);
        Assertions.assertEquals(-1, test.get(20));
        test.remove(65);
        test.put(57, 9);
        test.put(2, 41);
        test.remove(6);
        Assertions.assertEquals(87, test.get(33));
        test.put(16, 44);
        test.put(95, 30);
    }
}