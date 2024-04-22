package sheet.stack_and_queue;

import java.util.Arrays;
import java.util.Stack;

public class P25NextSmallerElement {

    public static int[] nextSmallerElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1); // Initialize all elements to -1

        for (int i = 0; i < arr.length; i++) {
            // While stack is not empty and the current element is less than the element at the index stored in the stack
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                result[stack.pop()] = arr[i]; // Set the next smaller element for the element at the index at the stack's top
            }
            stack.push(i); // Push the current index onto the stack
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 3};
        int[] res = nextSmallerElement(arr);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Next smaller elements: " + Arrays.toString(res));
    }
}

