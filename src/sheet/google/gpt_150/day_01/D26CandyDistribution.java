package sheet.google.gpt_150.day_01;

import java.util.Arrays;

public class D26CandyDistribution {

    private static int candyDistribution(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        // Left-to-right pass
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right-to-left pass
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int c : candies) {
            sum += c;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};

        System.out.println(candyDistribution(ratings));
    }
}
