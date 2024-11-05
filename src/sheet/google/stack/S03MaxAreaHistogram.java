package sheet.google.stack;

import java.util.Stack;

/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made
of a number of contiguous bars whose heights are given in an array. For simplicity, assume that all bars
have the same width and the width is 1 unit.
*/
public class S03MaxAreaHistogram {
    public static void main(String[] args) {
        int[] hist = {60, 20, 50, 40, 10, 50, 60};

        System.out.println(findMaxArea(hist));

        System.out.println(largestRectangleArea(hist));
    }

    // How to approach?
    // first of all maximum area can be achieved if buildings can be expanded to maximum from left or right
    // A building can only be expanded if nearest buildings are greater than it
    // So in short till its nearest building are smaller than it.
    // So if we consider a building i and calculate its NSL and NGL
    // area = height * (NSR - NSL - 1)
    // max area can be found from area of each i
    private static int findMaxArea(int[] hist) {
        int maxArea = 0;

        int[] nsl = nearestSmallerElementToLeft(hist);
        int[] nsr = nearestSmallerElementToRight(hist);

        for (int i = 0; i < hist.length; i++) {
            maxArea = Math.max(maxArea, hist[i] * (nsr[i] - nsl[i] - 1));
        }

        return maxArea;
    }

    private static int[] nearestSmallerElementToLeft(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            while (!stack.empty() && current <= stack.peek().element) {
                stack.pop();
            }

            res[i] = stack.empty() ? -1 : stack.peek().elementIndex;
            stack.push(new Pair(current, i));
        }

        return res;
    }

    private static int[] nearestSmallerElementToRight(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Pair> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];

            while (!stack.empty() && current <= stack.peek().element) {
                stack.pop();
            }

            res[i] = stack.empty() ? arr.length : stack.peek().elementIndex;
            stack.push(new Pair(current, i));
        }

        return res;
    }

    public static int largestRectangleArea(int[] heights) {
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

    static class Pair {
        int element;
        int elementIndex;

        public Pair(int e, int eI) {
            this.element = e;
            this.elementIndex = eI;
        }
    }
}
