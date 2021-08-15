package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/7/5 2:01 下午
 */
class Q726Test {

    @ParameterizedTest
    @CsvSource({"H2O,H2O", "Mg(OH)2,H2MgO2", "K4(ON(SO3)2)2,K4N2O14S4", "H11He49NO35B7N46Li20,B7H11He49Li20N47O35"})
    void countOfAtoms(String formula, String result) {
        Assertions.assertEquals(result, new Q726().countOfAtoms(formula));
    }
}