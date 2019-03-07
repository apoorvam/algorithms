package puzzle8;

import java.util.ArrayList;

public class Board {
    private final int dimension;

    private final int[][] blocks;

    public Board(int[][] blocks) {
        this.blocks = copy(blocks);
        this.dimension = blocks.length;
    }

    public int dimension() {
        return this.dimension;
    }

    public int hamming() {
        int hammingCount = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (blocks[i][j] == 0) continue;
                if (blocks[i][j] != goalValueOfBlock(i, j)) hammingCount++;
            }
        }
        return hammingCount;
    }

    private int goalValueOfBlock(int i, int j) {
        return (i * dimension + j + 1);
    }

    public int manhattan() {
        int distance = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (blocks[i][j] == 0) continue;
                int row = (blocks[i][j] - 1) / dimension;
                int col = (blocks[i][j] - 1) % dimension;
                distance += (row > i ? row - i : i - row) + (col > j ? col - j : j - col);
            }
        }
        return distance;
    }

    public boolean isGoal() {
        int start = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (blocks[i][j] == 0) continue;
                ++start;
                if (blocks[i][j] != start) return false;
            }
        }
        if (dimension > 0 && blocks[dimension-1][dimension-1] != 0) return false;
        return true;
    }

    public Board twin() {
        for (int row = 0; row < blocks.length; row++)
            for (int col = 0; col < blocks.length - 1; col++)
                if (blocks[row][col] != 0 && blocks[row][col + 1] != 0)
                    return new Board(swapCells(row, col, row, col + 1));

        return new Board(blocks);
    }

    private int[][] swapCells(int row1, int col1, int row2, int col2) {
        int[][] copy = copy(blocks);
        int tmp = copy[row1][col1];
        copy[row1][col1] = copy[row2][col2];
        copy[row2][col2] = tmp;

        return copy;
    }

    private int[][] copy(int[][] grid) {
        int[][] copy = new int[grid.length][grid.length];
        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid.length; col++)
                copy[row][col] = grid[row][col];

        return copy;
    }

    public boolean equals(Object y) {
        if (!this.getClass().isInstance(y)) return false;

        Board newBoard = (Board) y;
        if (this.dimension != newBoard.dimension()) return false;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++)
                if (blocks[i][j] != newBoard.blocks[i][j]) return false;
        }
        return true;
    }

    public Iterable<Board> neighbors() {
        ArrayList<Board> neighbours = new ArrayList<>();
        int[] zeroPosition = getZero();

        int zeroRow = zeroPosition[0];
        int zeroCol = zeroPosition[1];

        if (zeroRow > 0) neighbours.add(new Board(swapCells(zeroRow, zeroCol, zeroRow - 1, zeroCol)));
        if (zeroRow < dimension - 1) neighbours.add(new Board(swapCells(zeroRow, zeroCol, zeroRow + 1, zeroCol)));
        if (zeroCol > 0) neighbours.add(new Board(swapCells(zeroRow, zeroCol, zeroRow, zeroCol - 1)));
        if (zeroCol < dimension - 1) neighbours.add(new Board(swapCells(zeroRow, zeroCol, zeroRow, zeroCol + 1)));

        return neighbours;
    }

    private int[] getZero() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (blocks[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(dimension + "\n");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                builder.append(blocks[i][j] + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
