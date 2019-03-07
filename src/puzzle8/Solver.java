package puzzle8;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private Move lastMove;

    private class Move implements Comparable<Move> {
        private final Board board;
        private final int myManhattanDistance;
        private Move previous;
        private int moves;

        public Move(Board board) {
            this.board = board;
            this.myManhattanDistance = this.board.manhattan();
        }

        public Move(Move previous, Board board) {
            this.previous = previous;
            this.board = board;
            this.myManhattanDistance = this.board.manhattan();
            this.moves = previous.moves + 1;
        }

        @Override
        public int compareTo(Move other) {
            return (this.myManhattanDistance - other.myManhattanDistance) + (this.moves - other.moves);
        }
    }


    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException("Board cannot be null");

        MinPQ<Move> moves = new MinPQ<Move>();
        moves.insert(new Move(initial));

        MinPQ<Move> twinMoves = new MinPQ<Move>();
        twinMoves.insert(new Move(initial.twin()));

        while (true) {
            lastMove = moveFurther(moves);
            if (lastMove != null) {
                return;
            }
            Move a = moveFurther(twinMoves);
            if (a != null) {
                return;
            }
        }
    }

    private Move moveFurther(MinPQ<Move> moves) {
        if (moves.isEmpty()) return null;
        Move bestMove = moves.delMin();
        if (bestMove.board.isGoal()) return bestMove;

        for (Board neighbor : bestMove.board.neighbors()) {
            if (bestMove.previous == null || !neighbor.equals(bestMove.previous.board)) {
                moves.insert(new Move(bestMove, neighbor));
            }
        }
        return null;
    }

    public boolean isSolvable() {
        return lastMove != null;
    }

    public int moves() {
        if (!isSolvable()) return -1;
        return lastMove.moves;
    }

    public Iterable<Board> solution() {
        if (!isSolvable()) return null;

        Stack<Board> stack = new Stack<>();
        Move current = lastMove;
        while (current != null) {
            stack.push(current.board);
            current = current.previous;
        }

        return stack;
    }

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }


}
