package sheet.google.months_6._2;

//  https://leetcode.com/problems/maximal-rectangle

import java.util.Stack;

public class F05MaximalRectangle {

    public static void main(String[] args) {
        F05MaximalRectangle solution = new F05MaximalRectangle();

        char[][] matrix1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution.maximalRectangle(matrix1)); // Output: 6

        char[][] matrix2 = {
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println(solution.maximalRectangle(matrix2)); // Output: 1
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Array to store the heights of the histogram for each row
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // Update heights array for the current row
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            // Calculate the maximal rectangle area for the current histogram
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

            // Maintain the stack in increasing order
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}

