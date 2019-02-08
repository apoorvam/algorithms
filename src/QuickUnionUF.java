/*
Quick Union is an algorithm to solve dynamic connectivity problem.
An integer array of length N, where interpretation is that array[i] is the parent of i. Or root of i is arr[arr[..arr[i]]]
It stores the tree structure in array, by storing parent of each.

Complexity:
 Initialize: N
 Union: N (cost in finding roots)
 Find: N

Defect is that trees can get tall, which is expensive
*/

public class QuickUnionUF {
    private int[] nodes;

    public QuickUnionUF(int size) {
        nodes = new int[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = i;
        }
    }

    public void printNodes() {
        for (int i = 0; i < nodes.length; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();
        for (int n : nodes) {
            System.out.print(n + " | ");
        }
    }

    private int root(int i) {
        while (i != nodes[i]) i = nodes[i];
        return i;
    }

    public void union(int p, int q) {
        nodes[root(p)] = root(q);
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
