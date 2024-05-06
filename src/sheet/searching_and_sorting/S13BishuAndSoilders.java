package sheet.searching_and_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S13BishuAndSoilders {

    public static String getTotalStrength(List<Integer> strengths, int power) {
        Collections.sort(strengths); // Sort the soldiers' strengths in non-decreasing order
        int totalStrength = 0;
        int count = 0;

        // Iterate through the soldiers and select the ones that Bishu can defeat
        for (int strength : strengths) {
            if (strength <= power) {
                totalStrength += strength;
                count++;
            } else {
                break; // No need to check further as strengths are sorted
            }
        }

        return count + " " + totalStrength;
    }

    public static void main(String[] args) {
        List<Integer> strengths = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int power = 3;
        System.out.println(getTotalStrength(strengths, power));
    }
}

