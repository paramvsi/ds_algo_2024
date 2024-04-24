package sheet.strings;


public class S11CountNoOfStringIn2DCharacterArr {
    public static int countStringInGrid(char[][] grid, String target) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int len = target.length();

        // Directions arrays for row and column movements
        int[] rowDir = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] colDir = {0, 0, -1, 1, -1, 1, 1, -1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int d = 0; d < 8; d++) {
                    int rd = i, cd = j, k;
                    for (k = 0; k < len; k++) {
                        if (rd < 0 || rd >= rows || cd < 0 || cd >= cols || grid[rd][cd] != target.charAt(k)) break;
                        // Move in the direction d
                        rd += rowDir[d];
                        cd += colDir[d];
                    }

                    // If all characters matched, increase count
                    if (k == len) count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'a', 'b', 'a', 'b'}, {'a', 'b', 'e', 'b'}, {'e', 'b', 'e', 'b'}};
        String target = "bbb";
        System.out.println("Count of '" + target + "' in grid: " + countStringInGrid(grid, target));
    }
}

