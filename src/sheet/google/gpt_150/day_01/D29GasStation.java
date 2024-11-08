package sheet.google.gpt_150.day_01;


public class D29GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int currentGas = 0, startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If we run out of gas, reset start index and currentGas
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }

        // If the total gas is enough to cover the total cost, return startIndex; otherwise, return -1
        return totalGas >= totalCost ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Starting index: " + canCompleteCircuit(gas1, cost1)); // Expected output: 3

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Starting index: " + canCompleteCircuit(gas2, cost2)); // Expected output: -1
    }
}


