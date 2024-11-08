package sheet.google.gpt_150.day_01;

public class D06LemonadeChange {

    private static boolean isChangePossible(int[] bills) {
        int bill5 = 0;  // Count of $5 bills
        int bill10 = 0; // Count of $10 bills

        for (int bill : bills) {
            if (bill == 5) {
                bill5++;  // Accept $5, no change required
            } else if (bill == 10) {
                if (bill5 > 0) {
                    bill5--;  // Use one $5 as change
                    bill10++; // Accept $10
                } else {
                    return false; // Not enough $5 for change
                }
            } else if (bill == 20) {
                if (bill10 > 0 && bill5 > 0) {
                    bill10--; // Use one $10
                    bill5--;  // Use one $5
                } else if (bill5 >= 3) {
                    bill5 -= 3; // Use three $5 bills as change
                } else {
                    return false; // Not enough bills for change
                }
            }
        }

        return true; // Successfully provided change for all customers
    }

    public static void main(String[] args) {
        int[] bills1 = {5, 5, 5, 10, 20};
        int[] bills2 = {5, 5, 10, 10, 20};
        int[] bills3 = {5, 5, 5, 10, 20, 5, 10, 20};
        int[] bills4 = {10, 10};
        int[] bills5 = {5, 5, 10};

        System.out.println("Test Case 1: Expected true, Actual: " + isChangePossible(bills1));
        System.out.println("Test Case 2: Expected false, Actual: " + isChangePossible(bills2));
        System.out.println("Test Case 3: Expected true, Actual: " + isChangePossible(bills3));
        System.out.println("Test Case 4: Expected false, Actual: " + isChangePossible(bills4));
        System.out.println("Test Case 5: Expected true, Actual: " + isChangePossible(bills5));
    }
}
