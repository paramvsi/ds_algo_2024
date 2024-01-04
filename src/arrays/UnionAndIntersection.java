package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Find Union and Intersection of two unsorted arrays
public class UnionAndIntersection {
    public static void main(String[] args) {
        int[] arr1 = {7, 1, 5, 2, 3, 6};
        int[] arr2 = {3, 8, 6, 20, 7};

        System.out.println("Array 1 ::" + Arrays.toString(arr1));
        System.out.println("Array 2 ::" + Arrays.toString(arr2));

        findUnionAndIntersection(arr1, arr2);
    }

    private static void findUnionAndIntersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        List<Integer> union = new ArrayList<>();
        List<Integer> intersection = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                union.add(arr1[i]);
                i++;
            } else if(arr2[j] < arr1[i]){
                union.add(arr2[j]);
                j++;
            } else {
                union.add(arr1[i]);
                intersection.add(arr1[i]);
                i++;
                j++;
            }
        }

        while(i < arr1.length){
            union.add(arr1[i++]);
        }

        while(j < arr2.length){
            union.add(arr2[j++]);
        }

        System.out.println("Union is :: "+ union);
        System.out.println("intersection is :: "+ intersection);
    }
}
