package arrays;

// Given a set of time intervals in any order, our task is to merge all overlapping intervals
// into one and output the result which should have only mutually exclusive intervals.
public class MergeIntervals {

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval[] arr = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        mergeIntervals(arr);
    }

    private static void mergeIntervals(Interval[] arr) {
       // To Do
    }
}
