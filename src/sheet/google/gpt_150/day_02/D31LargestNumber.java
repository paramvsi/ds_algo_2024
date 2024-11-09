package sheet.google.gpt_150.day_02;


import java.util.Arrays;

public class D31LargestNumber {

    public static String largestNumber(int[] nums) {
        // Convert each integer to a string
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort strings based on the custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Join sorted strings to form the result
        StringBuilder result = new StringBuilder();
        for (String str : strNums) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums = {2, 10, 7, 5};
        System.out.println(largestNumber(nums)); // Output: "75210"
    }
}


