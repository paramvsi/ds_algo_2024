package sheet.stack_and_queue;

import java.util.Stack;

public class P12LargestRectangularAreaInHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < heights.length) {
            // Push index to stack when the current height is greater than the height of the bar at stack's top
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index);
                index++;
            } else {
                // Calculate max area when the current height is less than the height of the bar at stack's top
                int topOfStack = stack.pop();
                // Calculate the area with heights[topOfStack] as the smallest height
                int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        // Now pop the remaining bars from stack and calculate area with each popped bar
        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("The largest rectangular area is: " + largestRectangleArea(heights));
    }
}

