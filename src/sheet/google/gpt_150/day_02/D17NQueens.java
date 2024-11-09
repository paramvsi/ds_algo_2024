package sheet.google.gpt_150.day_02;


import java.util.ArrayList;
import java.util.List;

public class D17NQueens {

    public static void main(String[] args) {
        D17NQueens solver = new D17NQueens();
        List<List<String>> solutions = solver.solveNQueens(4);

        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with empty spaces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Arrays to track columns and diagonals where queens are placed
        boolean[] cols = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];

        backtrack(solutions, board, 0, cols, diagonal1, diagonal2, n);
        return solutions;
    }

    private void backtrack(List<List<String>> solutions, char[][] board, int row,
                           boolean[] cols, boolean[] diagonal1, boolean[] diagonal2, int n) {
        // If all queens are placed, add the current board to the solutions
        if (row == n) {
            solutions.add(buildSolution(board));
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            int d1 = row + col;         // Index for `/` diagonal
            int d2 = row - col + n - 1; // Index for `\` diagonal

            // Check if the column and diagonals are free
            if (cols[col] || diagonal1[d1] || diagonal2[d2]) continue;

            // Place the queen
            board[row][col] = 'Q';
            cols[col] = diagonal1[d1] = diagonal2[d2] = true;

            // Move to the next row
            backtrack(solutions, board, row + 1, cols, diagonal1, diagonal2, n);

            // Backtrack: remove the queen and reset tracking
            board[row][col] = '.';
            cols[col] = diagonal1[d1] = diagonal2[d2] = false;
        }
    }

    private List<String> buildSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}

