package sheet.strings;

import java.util.ArrayList;
import java.util.List;

public class S12SearchWordIn2DCharacterArr {

    private static final int[] xDir = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] yDir = {0, 0, -1, 1, -1, 1, -1, 1};

    public static List<String> findWords(char[][] grid, String[] words) {
        List<String> foundWords = new ArrayList<>();
        for (String word : words) {
            if (searchWordInGrid(grid, word)) {
                foundWords.add(word);
            }
        }
        return foundWords;
    }

    private static boolean searchWordInGrid(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int d = 0; d < 8; d++) {
                    if (searchFromCell(grid, word, i, j, d)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean searchFromCell(char[][] grid, String word, int row, int col, int dirIndex) {
        int len = word.length();
        int endRow = row + xDir[dirIndex] * (len - 1);
        int endCol = col + yDir[dirIndex] * (len - 1);

        // Check bounds
        if (endRow < 0 || endRow >= grid.length || endCol < 0 || endCol >= grid[0].length) {
            return false;
        }

        for (int k = 0; k < len; k++) {
            int newRow = row + xDir[dirIndex] * k;
            int newCol = col + yDir[dirIndex] * k;
            if (grid[newRow][newCol] != word.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'S', 'E', 'E'}
        };
        String[] words = {"ABC", "SEE", "ABCB"};
        List<String> foundWords = findWords(grid, words);
        System.out.println("Words found: " + foundWords);
    }
}
