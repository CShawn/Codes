package com.cshawn.codes.leetcodes.everyday;

/**
 * 并查集
 * @author C.Shawn
 * @date 2021/2/14 12:26 下午
 */
public class UnionFind {
    private int[] parent;

    private int count;

    public int getCount() {
        return count;
    }

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // 查
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        // 简单并查集
//        return find(parent[x]);
        // 路径优化如下
        parent[x] = find(parent[x]);
        return parent[x];
    }

    // 并
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;
        count--;
    }
}
