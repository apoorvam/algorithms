import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

/*
* Implementation of priority queue(collection of items with capability to remove largest or smallest ones) using binary heap.
* Find largest M fraud detections in streams of N.
*
* Heap ordered binary tree: parents key is no smaller than children's keys. Its represented in array starting from index 1.
* Starting from level 1, its stored in order of the tree nodes from left to right. No links. a[1] is largest key.
* Using methods like, swim and sink, the order of tree is maintained every time it changes.
*
* Complexiety:
* Insert: ln n
* Delete: ln n
* Max/Min: 1
* */
public class MaxPriorityQueue {

    private String[] arr;
    private int N;

    public MaxPriorityQueue() {
        arr = new String[3];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(String key) {
        if (N == arr.length - 1) resize(2 * N);
        arr[++N] = key;
        swim(N);
    }

    public String deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("No such element");
        String max = arr[1];
        String dummy = arr[N];
        arr[1] = dummy;
        arr[N--] = null;
        if (!isEmpty()) sink(1);
        return max;
    }

    public String sample() {
        if (isEmpty()) throw new NoSuchElementException("No such element");
        int index = StdRandom.uniform(1, N + 1);
        return arr[index];
    }

    private void swim(int n) {
        while (n > 1 && less(n / 2, n)) {
            swap(n / 2, n);
            n = n / 2;
        }
    }

    private void sink(int i) {
        while (2 * i <= N) {
            int j = 2 * i;
            if (j < N && less(j, j + 1)) j++;
            if (!less(i, j)) break;
            swap(i, j);
            i = j;
        }
    }

    private void resize(int capacity) {
        String[] newArr = new String[capacity];
        for (int i = 0; i < arr.length; i++) newArr[i] = arr[i];
        arr = newArr;
    }

    private void swap(int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean less(int j, int i) {
        return arr[j].compareTo(arr[i]) < 0;
    }
}
