package sheet.google.gpt_150.day_02;


public class D24SodukoSolver {

    public static void main(String[] args) {
        D24SodukoSolver solver = new D24SodukoSolver();

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solver.solveSudoku(board);

        // Print solved board
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        // Traverse each cell in the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') { // Find an empty cell
                    // Try placing numbers 1-9 in the empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Place the number

                            // Recursively attempt to solve the rest of the board
                            if (backtrack(board)) {
                                return true;
                            }

                            // Backtrack: remove the number if it leads to a dead end
                            board[row][col] = '.';
                        }
                    }
                    return false; // No valid numbers found for this cell, trigger backtracking
                }
            }
        }
        return true; // All cells are filled with valid numbers
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // Check the 3x3 sub-box
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRowStart + i][boxColStart + j] == num) return false;
            }
        }

        return true;
    }
}

