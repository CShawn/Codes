package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/3/19 8:46 上午
 */
class Q1603Test {
    @Test
    void test1() {
        Q1603.ParkingSystem1 test = new Q1603().new ParkingSystem1(0,1,2);
        Assertions.assertFalse(test.addCar(1));
        Assertions.assertTrue(test.addCar(2));
        Assertions.assertFalse(test.addCar(2));
        Assertions.assertTrue(test.addCar(3));
        Assertions.assertTrue(test.addCar(3));
        Assertions.assertFalse(test.addCar(3));
    }

    @Test
    void test() {
        Q1603.ParkingSystem test = new Q1603().new ParkingSystem(0,1,2);
        Assertions.assertFalse(test.addCar(1));
        Assertions.assertTrue(test.addCar(2));
        Assertions.assertFalse(test.addCar(2));
        Assertions.assertTrue(test.addCar(3));
        Assertions.assertTrue(test.addCar(3));
        Assertions.assertFalse(test.addCar(3));
    }
}