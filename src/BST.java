/*
* Binary Search Tree - A binary tree where all the keys of left sub tree of a node are less than key of node itself,
* and all the keys in right subtree of a node are greater than node.
*
* Time complexity: Log n in average case, when nodes are randomized.
* In worst case, when nodes are in ascending or descending order, tree leans to one side and becomes linear.
* */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Node left;
        private Node right;
        private Key key;
        private Value value;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public BST() {
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return size(root) == 0;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        root = insert(root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = insert(node.left, key, value);
        else if (cmp > 0) node.right = insert(node.right, key, value);
        else node.value = value;

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public String inorder() {
        StringBuilder builder = new StringBuilder();
        builder = inorder(builder, root);
        return builder.toString().trim();
    }

    private StringBuilder inorder(StringBuilder builder, Node node) {
        if (node == null) return builder;
        inorder(builder, node.left);
        builder.append(node.key + " ");
        inorder(builder, node.right);
        return builder;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node.value;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        return contains(root, key);
    }

    private boolean contains(Node node, Key key) {
        if (node == null) return false;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) return contains(node.left, key);
        else if (cmp > 0) return contains(node.right, key);
        else return true;
    }

    public Iterable<Key> levelOrder() {
        edu.princeton.cs.algs4.Queue<Key> keys = new edu.princeton.cs.algs4.Queue<>();
        edu.princeton.cs.algs4.Queue<Node> nodes = new edu.princeton.cs.algs4.Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.dequeue();
            if (node == null) continue;
            keys.enqueue(node.key);
            nodes.enqueue(node.left);
            nodes.enqueue(node.right);
        }
        return keys;
    }

}
