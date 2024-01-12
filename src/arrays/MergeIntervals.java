package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a set of time intervals in any order, our task is to merge all overlapping intervals
// into one and output the result which should have only mutually exclusive intervals.
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        int[][] res = mergeIntervals(arr);

        for(int[] a: res){
            System.out.print(Arrays.toString(a)+"  ");
        }
    }

    private static int[][] mergeIntervals(int[][] arr) {
        if (arr.length == 1) return arr;

        List<int[]> result = new ArrayList<>();

        int[] newInterval = arr[0];
        result.add(newInterval);

        for (int[] item : arr) {
            if (item[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], item[1]);
            } else {
                newInterval = item;
                result.add(newInterval);
            }
        }

        return result.toArray(new int [result.size()][]);
    }
}
