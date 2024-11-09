package sheet.google.gpt_150.day_03;


import java.util.HashSet;
import java.util.Set;

public class D07MinimumCostForTickets {

    public static void main(String[] args) {
        D07MinimumCostForTickets solution = new D07MinimumCostForTickets();

        int[] days1 = {1, 4, 6, 7, 8, 20};
        int[] costs1 = {2, 7, 15};
        System.out.println("Minimum cost: " + solution.mincostTickets(days1, costs1)); // Output: 11

        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs2 = {2, 7, 15};
        System.out.println("Minimum cost: " + solution.mincostTickets(days2, costs2)); // Output: 17
    }

    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        Set<Integer> travelDays = new HashSet<>();

        // Add all travel days to a set for quick lookup
        for (int day : days) {
            travelDays.add(day);
        }

        // DP to calculate minimum cost for each day up to last travel day
        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays.contains(i)) {
                // No travel on this day, cost remains same as previous day
                dp[i] = dp[i - 1];
            } else {
                // Travel on this day, calculate the minimum of all ticket options
                dp[i] = Math.min(
                        dp[i - 1] + costs[0], // 1-day ticket
                        Math.min(
                                dp[Math.max(0, i - 7)] + costs[1], // 7-day ticket
                                dp[Math.max(0, i - 30)] + costs[2] // 30-day ticket
                        )
                );
            }
        }

        return dp[lastDay];
    }
}

