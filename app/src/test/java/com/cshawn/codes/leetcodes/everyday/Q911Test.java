package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author C.Shawn
 * @date 2021/12/11 8:15 下午
 */
class Q911Test {
    @Test
    void test() {
        Q911.TopVotedCandidate topVotedCandidate = new Q911.TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0, 0}, new int[]{0, 5, 10, 15, 20, 25, 30, 35});
        Assertions.assertEquals(0, topVotedCandidate.q(0));
        Assertions.assertEquals(0, topVotedCandidate.q(3));
        Assertions.assertEquals(1, topVotedCandidate.q(5));
        Assertions.assertEquals(1, topVotedCandidate.q(10));
        Assertions.assertEquals(1, topVotedCandidate.q(12));
        Assertions.assertEquals(0, topVotedCandidate.q(15));
        Assertions.assertEquals(0, topVotedCandidate.q(18));
        Assertions.assertEquals(0, topVotedCandidate.q(20));
        Assertions.assertEquals(0, topVotedCandidate.q(21));
        Assertions.assertEquals(1, topVotedCandidate.q(25));
        Assertions.assertEquals(0, topVotedCandidate.q(24));
        Assertions.assertEquals(1, topVotedCandidate.q(8));
        Assertions.assertEquals(0, topVotedCandidate.q(30));
        Assertions.assertEquals(0, topVotedCandidate.q(35));

        topVotedCandidate = new Q911.TopVotedCandidate(new int[]{0,0,0,1,1}, new int[]{0,6,39,52,75});
        Assertions.assertEquals(0, topVotedCandidate.q(0));
        Assertions.assertEquals(0, topVotedCandidate.q(26));
        Assertions.assertEquals(0, topVotedCandidate.q(37));
        Assertions.assertEquals(0, topVotedCandidate.q(42));
        Assertions.assertEquals(0, topVotedCandidate.q(43));
        Assertions.assertEquals(0, topVotedCandidate.q(45));
        Assertions.assertEquals(0, topVotedCandidate.q(49));
        Assertions.assertEquals(0, topVotedCandidate.q(59));
        Assertions.assertEquals(0, topVotedCandidate.q(68));
        Assertions.assertEquals(0, topVotedCandidate.q(78));
        Assertions.assertEquals(0, topVotedCandidate.q(99));
    }
}