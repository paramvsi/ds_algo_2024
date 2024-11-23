package sheet.google.months_6;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//  https://leetcode.com/problems/snapshot-array
public class F19SnapShotArray {

    private final List<TreeMap<Integer, Integer>> array; // List of maps for each index
    private int snapId; // Current snapshot ID

    public F19SnapShotArray(int length) {
        snapId = 0;
        array = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            array.add(new TreeMap<>());
            array.get(i).put(0, 0); // Initialize all indices with snap_id = 0 and value = 0
        }
    }

    public static void main(String[] args) {
        F19SnapShotArray snapshotArray = new F19SnapShotArray(3);

        snapshotArray.set(0, 5);
        System.out.println(snapshotArray.snap()); // Output: 0
        snapshotArray.set(0, 6);
        System.out.println(snapshotArray.get(0, 0)); // Output: 5
    }

    public void set(int index, int val) {
        // Set the value for the current snapId
        array.get(index).put(snapId, val);
    }

    public int snap() {
        // Increment snapId and return the previous one
        return snapId++;
    }

    public int get(int index, int snap_id) {
        // Get the value for the largest snap_id <= snap_id using floorEntry
        return array.get(index).floorEntry(snap_id).getValue();
    }
}

