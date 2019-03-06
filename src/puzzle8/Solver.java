package puzzle8;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private class Move implements Comparable<Move>{
        private Move previous;
        private Board board;
        private int moves;
        public Move(Board board) {
            this.board = board;
        }

        public Move(Move previous, Board board) {
            this.previous = previous;
            this.board = board;
            this.moves = previous.moves +1;
        }

        @Override
        public int compareTo(Move o) {
            return (this.board.manhattan() - o.board.manhattan()) + (this.moves - o.moves);
        }
    }

    private Move lastMove;

    public Solver(Board initial) {
        MinPQ<Move> moves = new MinPQ<Move>();
        moves.insert(new Move(initial));

        MinPQ<Move> twinMoves = new MinPQ<Move>();
        twinMoves.insert(new Move(initial.twin()));
        
        while(true) {
            lastMove = moveFurther(moves);
            if (lastMove != null || moveFurther(twinMoves) != null) return;
        }
    }

    private Move moveFurther(MinPQ<Move> moves) {
        if(moves.isEmpty()) return null;
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

    private int moves() {
        if (!isSolvable()) return -1;
        return lastMove.moves;
    }

    private Iterable<Board> solution() {
        Stack<Board> stack = new Stack<>();
        if (!isSolvable()) return stack;

        Move current = lastMove;
        while(current.previous != null) {
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
