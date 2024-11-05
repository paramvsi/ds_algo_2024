package sheet.google.stack;

// Next Greater Element (NGE) for every element in given Array

// Given an array, print the Next Greater Element (NGE) for every element.

import java.util.Arrays;
import java.util.Stack;

// Note: The Next greater Element for an element x is the first greater element on the right side of x in the array.
// Elements for which no greater element exist, consider the next greater element as -1.
public class S01NearestGreaterElementToRight {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int[] arr2 = {13 , 7, 6 , 12};

        System.out.println("Nearest Greater Element to Right");

        System.out.println(Arrays.toString(nearestGreaterElement(arr)));
        System.out.println(Arrays.toString(nearestGreaterElement(arr2)));

        System.out.println("Nearest Greater Element to Left");

        System.out.println(Arrays.toString(nearestGreaterElementToLeft(arr)));
        System.out.println(Arrays.toString(nearestGreaterElementToLeft(arr2)));

        System.out.println("Nearest Smaller Element to Left");

        System.out.println(Arrays.toString(nearestSmallerElementToLeft(arr)));
        System.out.println(Arrays.toString(nearestSmallerElementToLeft(arr2)));

        System.out.println("Nearest Smaller Element to Right");

        System.out.println(Arrays.toString(nearestSmallerElementToRight(arr)));
        System.out.println(Arrays.toString(nearestSmallerElementToRight(arr2)));

    }

    // For solution we will use Stack. We will track current element
    // Compare current element to tos and check if current element is less than current tos
    // if tos is smaller than ce than pop otherwise put tos in output and push ce to tos for next iteration
    private static int[] nearestGreaterElement(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];

            while (!stack.empty() && current >= stack.peek()) {
                stack.pop();
            }

            res[i] = stack.empty() ? -1 : stack.peek();
            stack.push(current);
        }


        return res;
    }


    // Variation 2 -> Find nearest greater element to right
    // Solution -> Reverse above solution
    private static int[] nearestGreaterElementToLeft(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            while (!stack.empty() && current >= stack.peek()) {
                stack.pop();
            }

            res[i] = stack.empty() ? -1 : stack.peek();
            stack.push(current);
        }

        return res;
    }

    // Variation 3 -> Find nearest smaller element to left
    // Solution ->
    private static int[] nearestSmallerElementToLeft(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            while (!stack.empty() && current <= stack.peek()) {
                stack.pop();
            }

            res[i] = stack.empty() ? -1 : stack.peek();
            stack.push(current);
        }

        return res;
    }

    // Variation 4 -> Find nearest smaller element to right
    // Solution ->
    private static int[] nearestSmallerElementToRight(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];

            while (!stack.empty() && current <= stack.peek()) {
                stack.pop();
            }

            res[i] = stack.empty() ? -1 : stack.peek();
            stack.push(current);
        }

        return res;
    }


}
