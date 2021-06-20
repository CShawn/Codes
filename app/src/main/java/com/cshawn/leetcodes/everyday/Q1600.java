package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * @author C.Shawn
 * @date 2021/6/20 2:48 下午
 */
public class Q1600 {
    static class ThroneInheritance {
        private Map<String, List<String>> edges;
        private Set<String> dead;
        private String king;
        public ThroneInheritance(String kingName) {
            king = kingName;
            edges = new HashMap<>();
            dead = new HashSet<>();
            edges.put(kingName, new LinkedList<>());
        }

        public void birth(String parentName, String childName) {
            edges.put(childName, new LinkedList<>());
            edges.get(parentName).add(childName);
        }

        public void death(String name) {
            dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> result = new ArrayList<>();
            getInheritanceOrder(result, king);
            return result;
        }

        private void getInheritanceOrder(List<String> result, String parent) {
            if (!dead.contains(parent)) {
                result.add(parent);
            }
            List<String> children = edges.get(parent);
            for (String child : children) {
                getInheritanceOrder(result, child);
            }
        }
    }
}
