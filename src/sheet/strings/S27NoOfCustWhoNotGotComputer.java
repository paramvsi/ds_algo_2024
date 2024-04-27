package sheet.strings;


import java.util.HashMap;
import java.util.Map;

public class S27NoOfCustWhoNotGotComputer {

    public static int countCustomersWithoutComputer(int numComputers, String sequence) {
        Map<Character, Boolean> customerUsingComputer = new HashMap<>();
        int freeComputers = numComputers;
        int customersWithoutComputer = 0;

        for (char customer : sequence.toCharArray()) {
            if (customerUsingComputer.containsKey(customer)) {
                // Customer is leaving, free up a computer
                freeComputers++;
                customerUsingComputer.remove(customer);
            } else {
                // Customer is arriving
                if (freeComputers > 0) {
                    // Assign a computer to this customer
                    freeComputers--;
                    customerUsingComputer.put(customer, true);
                } else {
                    // No computer available, customer leaves
                    customersWithoutComputer++;
                }
            }
        }

        return customersWithoutComputer;
    }

    public static void main(String[] args) {
        String sequence = "ABBAJJKZKZ";
        int numComputers = 2;
        System.out.println("Number of customers who could not get a computer: " + countCustomersWithoutComputer(numComputers, sequence));
    }
}

