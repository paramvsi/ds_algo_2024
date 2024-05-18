package sheet.graphs.problems;


public class G05FloodFillAlgo {
    // Function to fill the connected pixels with the new color
    public static void floodFill(int[][] screen, int x, int y, int prevColor, int newColor) {
        // Base cases
        if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length)
            return;
        if (screen[x][y] != prevColor)
            return;
        if (screen[x][y] == newColor)
            return;

        // Replace the color at (x, y)
        screen[x][y] = newColor;

        // Recur for north, east, south, and west
        floodFill(screen, x + 1, y, prevColor, newColor);
        floodFill(screen, x - 1, y, prevColor, newColor);
        floodFill(screen, x, y + 1, prevColor, newColor);
        floodFill(screen, x, y - 1, prevColor, newColor);
    }

    // Utility function to start the flood fill
    public static void startFloodFill(int[][] screen, int x, int y, int newColor) {
        int prevColor = screen[x][y];
        if (prevColor != newColor) {
            floodFill(screen, x, y, prevColor, newColor);
        }
    }

    // Function to print the screen
    public static void printScreen(int[][] screen) {
        for (int[] row : screen) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] screen = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };

        int x = 4; // Starting X coordinate
        int y = 4; // Starting Y coordinate
        int newColor = 3; // New color to fill with

        System.out.println("Original Screen:");
        printScreen(screen);

        startFloodFill(screen, x, y, newColor);

        System.out.println("Screen after Flood Fill:");
        printScreen(screen);
    }
}

