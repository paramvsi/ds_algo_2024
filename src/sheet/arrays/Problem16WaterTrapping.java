package sheet.arrays;

// Given an array of N non-negative integers arr[] representing an elevation map where the width of each bar is 1,
// compute how much water it is able to trap after raining.
public class Problem16WaterTrapping {

    public static void main(String[] args) {

        int[] height =  {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Total units of trapped water is "+ trap(height));
    }


    public static int trap(int[] height) {
        int n = height.length;

        int[] maxL = new int[n];
        int[] maxR = new int[n];

        maxL[0] = height[0];
        maxR[n-1] = height[n-1];

        for(int i = 1; i < n ; i++){
            maxL[i] = Math.max(maxL[i-1], height[i]);
        }

        for(int i = n-2; i  >= 0 ; i--){
            maxR[i] = Math.max(maxR[i+1], height[i]);
        }

        int[] water = new int[n];

        for(int i = 0; i < n; i++){
            water[i] = Math.min(maxL[i], maxR[i]) - height[i];
        }

        int res  = 0;
        for(int i = 0; i < n; i++){
            res += water[i];
        }

        return res;

    }
}
