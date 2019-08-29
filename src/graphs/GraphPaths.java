package graphs;

public interface GraphPaths {
    public boolean hasPathTo(int v);
    public Iterable<Integer> pathTo(int v);
}