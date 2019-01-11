package com.company;

/*
Quick Find is an algorithm to solve dynamic connectivity problem.
An integer array of length N, where p and q are interpreted as connected if value of array[p] and array[q] are equal

Complexiety:
 Initialize: N
 Union: N
 Find: 1

Defect is that trees are flat, which is expensive.
*/
public class QuickFindUF {

    private int[] nodes;

    public QuickFindUF(int size) {
        nodes = new int[size];
        for (int i = 0; i< size; i++) {
            nodes[i] = i;
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

    public void union(int p, int q) {
        int valP = nodes[p];
        int valQ = nodes[q];
        for (int i = 0; i< nodes.length ; i++) {
            if (nodes[i] == valP) {
                nodes[i] = valQ;
            }
        }
    }

    public boolean connected(int p, int q) {
        return nodes[p] == nodes[q];
    }
}
