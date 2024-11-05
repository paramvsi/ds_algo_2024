package sheet.google.stack;

import java.util.Stack;

public class S04MaxAreaOfRectangleInBinaryMatrix {
    public static void main(String[] args) {
        S04MaxAreaOfRectangleInBinaryMatrix solution = new S04MaxAreaOfRectangleInBinaryMatrix();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println("Maximum area of rectangle: " + solution.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int maxArea = 0;
        int[] heights = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                // Update heights array based on binary matrix row
                heights[col] = matrix[row][col] == '1' ? heights[col] + 1 : 0;
            }
            // Calculate maximum area for current row as histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

