package com.company;

/*
Weighted Quick Union.

This is an enhancement of Quick Union, an algorithm to solve dynamic connectivity problem.
An integer array of length N, where interpretation is that array[i] is the parent of i. Or root of i is arr[arr[..arr[i]]]
The improvement here is that, size of each tree is maintained in an array. While doing union, smaller tree is merged with
larger one, thus avoiding the problem of tall trees.

Complexiety:
 union and connected/find takes time proportional to depth of p and q in tree.
 Depth of any node is at most ln N.

Using path compression, we can make tree flatter, which makes it close to linear algorithm.
*/

public class QuickUnionUFImproved {
    private int[] nodes;
    private int[] nodeSizes;

    public QuickUnionUFImproved(int size) {
        nodes = new int[size];
        nodeSizes = new int[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = i;
            nodeSizes[i] = i;
        }
    }

    public void printNodes() {
        for (int i = 0; i < nodes.length; i++) {
            System.out.print(i+ " | ");
        }
        System.out.println();
        for (int n : nodes) {
            System.out.print(n + " | ");
        }
    }

    private int root(int i) {
        while(i != nodes[i]) {
            i = nodes[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) return;
        if (nodeSizes[pRoot] < nodeSizes[qRoot]) {
            nodes[qRoot] = pRoot;
            nodeSizes[qRoot] += nodeSizes[pRoot];
        } else {
            nodes[pRoot] = qRoot;
            nodeSizes[pRoot] += nodeSizes[qRoot];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
