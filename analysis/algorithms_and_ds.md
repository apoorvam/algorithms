# Algorithms and Data Structures

**Algorithm**: method for solving a problem
**Data structure**: method to store information

* Data types: [Stack](/src/Stack.java), [Queue](/src/Queue.java), Bag, [Union-Find](/src/QuickUnionUF.java), [Priority queue](/src/MaxPriorityQueue.java)
* Sorting: [Quicksort](/src/sorting/Quick.java), [Mergesort](/src/sorting/Merge.java), [Selection sort](/src/sorting/Selection.java), [Insertion sort](/src/sorting/Insertion.java)
* Searching: [BST](/src/BST.java), red-black BST, [Hash Table](/analysis/hashing.md)
* Graphs: BFS, DFS, Prim, Kruskal, Dijikstra
* Strings: KMP, Regexps, TST, Huffman, LZW
* Advanced: B-Tree, Suffix array, maxflow

## Undirected Graphs

**Graph:** Set of vertices connected pairwise by edges.

Graph API:

```
public class Graph
	Graph(int V)
	Graph(In in)
void addEdge(int v, int w)
Iterable<Integer> adj(int v)
int V()
int E()
String toString()
```

**Path:** Sequence of vertices connected by edges.
**Cycle:** Path whose first and last vertices are same.

Common graph problems:

* Is there a path between vertices x and y?
* What is shortest path between x and y?
* Is there a cycle in graph? - shortcircuit
* Euler tour: Is there a cycle that uses each edge exactly once?
* Hamilton tour: Is there a cycle that uses each vertex exactly once?
* Connectivity: Is there a way to connect all vertices?
* MST: What is best way to connect all vertices?

Possible Graph representations:

* Set of Edges: Maintain a list of edges(linked list or array)
* Adjacency Matrix: Maintain a 2D V*V boolean array. Duplicate entries and space in-efficient
* [Adjacency List](/src/graphs/Graph.java): Maintain vertex-indexed array of lists

In Adjacency list, each vertex will have a entry in array. Each of this entry points to a list which has all vertices to which given vertex is connected to.

![Graph representations time complexiety](/assets/graph_representation_tc.png)

Sparse and Dense Graphs: Degree of each vertex in graph is less/high.

## Depth First Search

* Maze exploration
* Mark each visited intersection(vertex) and passage(edge)
* Retrace steps when no unvisited options. Key this is that no path is visited twice.

[DFS](/src/graphs/Paths.java)
Goal: Systematically search all vertices of a graph
Idea: Mimic maze exploration

```
DFS(to visit a vertex v)

Mark v as visited
Recursively visit all unmarked vertices w adjacent to v
```

