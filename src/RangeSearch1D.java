import edu.princeton.cs.algs4.StdIn;

/*
* 1D Range count - using BST
*
* Time: ~ log N
* */
public class RangeSearch1D<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Node left;
        private Node right;
        private Value value;
        private Key key;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public static void main(String[] args) {
        int count = Integer.parseInt(StdIn.readLine());

        RangeSearch1D store = new RangeSearch1D();
        for (int i = 0; i < count; i++)
            store.insert(Integer.parseInt(StdIn.readString()), null);

        int low = Integer.parseInt(StdIn.readString());
        int high = Integer.parseInt(StdIn.readString());

        store.rangeCount(low, high);

    }

    // Number of nodes in tree in range of [low, high), low included and high excluded
    public int rangeCount(Key low, Key high) {
        if (low == null || high == null) throw new IllegalArgumentException("Key cannot be null");
        int cmp = low.compareTo(high);
        if (cmp > 0) return 0;

        return rank(high) - rank(low);
    }

    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        return rank(root, key);
    }

    // Number of keys in the subtree less than key.
    private int rank(Node node, Key key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) return size(node.left) + 1 + rank(node.right, key);
        else if (cmp < 0) return rank(node.left, key);
        return size(node.left);
    }

    public void insert(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        root = insert(root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = insert(node.left, key, value);
        else if (cmp > 0) node.right = insert(node.right, key, value);
        else node.value = value;

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
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

}
