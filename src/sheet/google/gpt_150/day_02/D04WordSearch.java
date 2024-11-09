package sheet.google.gpt_150.day_02;


public class D04WordSearch {
    public static void main(String[] args) {
        D04WordSearch ws = new D04WordSearch();

        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(ws.exist(board1, "ABCCED")); // Output: true
        System.out.println(ws.exist(board1, "SEE")); // Output: true
        System.out.println(ws.exist(board1, "ABCB")); // Output: false
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        // Base case: If we have found the complete word
        if (index == word.length()) {
            return true;
        }

        // Boundary checks and character match check
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited by replacing it with a temporary character
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all four possible directions
        boolean found = dfs(board, word, row + 1, col, index + 1) ||
                dfs(board, word, row - 1, col, index + 1) ||
                dfs(board, word, row, col + 1, index + 1) ||
                dfs(board, word, row, col - 1, index + 1);

        // Restore the cell's original character (backtracking)
        board[row][col] = temp;

        return found;
    }
}

