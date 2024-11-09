package sheet.google.gpt_150.day_03;


import java.util.Stack;

public class D08LargestRectangleInAHistogram {

    public static void main(String[] args) {
        D08LargestRectangleInAHistogram solution = new D08LargestRectangleInAHistogram();

        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest rectangle area: " + solution.largestRectangleArea(heights1)); // Output: 10

        int[] heights2 = {2, 4};
        System.out.println("Largest rectangle area: " + solution.largestRectangleArea(heights2)); // Output: 4
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            // Handle the end of the array by using height 0
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            // Calculate area for rectangles with heights greater than the current height
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // Height of the rectangle
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Width calculation
                maxArea = Math.max(maxArea, height * width); // Update max area
            }

            // Push the current bar's index onto the stack
            stack.push(i);
        }

        return maxArea;
    }
}

