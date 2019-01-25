import edu.princeton.cs.algs4.StdIn;

/*
* Write a client program Permutation.java that takes an integer k as a command-line argument; reads in a sequence of strings from standard input using StdIn.readString();
* and prints exactly k of them, uniformly at random. Print each item from the sequence at most once.
*
* Sample input file contents given by StdIn: A B C D E F G H I
*
* To run this: `java -cp ./out/production/Algorithms:lib/algs4.jar Permutation 4 < input.txt`
* */
public class Permutation {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid number of arguments");
            return;
        }

        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> q = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        for (int j = 0; j < k; j++) {
            System.out.println(q.dequeue());
        }
    }
}
