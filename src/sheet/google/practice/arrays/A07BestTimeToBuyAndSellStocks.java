package sheet.google.practice.arrays;


public class A07BestTimeToBuyAndSellStocks {
    public static int maxProfit(int[] prices) {
        // Implement your logic here
        int minPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit; // Default return value, change as needed
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4}; // Example input
        System.out.println("Maximum profit: " + maxProfit(prices));
    }
}

