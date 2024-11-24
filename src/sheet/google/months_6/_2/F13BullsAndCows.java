package sheet.google.months_6._2;


public class F13BullsAndCows {
    public static void main(String[] args) {
        F13BullsAndCows solution = new F13BullsAndCows();

        // Test cases
        System.out.println(solution.getHint("1807", "7810")); // Output: "1A3C"
        System.out.println(solution.getHint("1123", "0111")); // Output: "1A1C"
        System.out.println(solution.getHint("1", "0"));       // Output: "0A0C"
        System.out.println(solution.getHint("1", "1"));       // Output: "1A0C"
    }

    public String getHint(final String secret, final String guess) {
        final int[] numbers = new int[10];

        int cows = 0, bulls = 0;

        for(int i = 0; i < secret.length(); ++i) {
            final int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';

            if(s == g) {
                bulls++;
            } else {
                if(numbers[s] < 0)
                    cows++;
                if(numbers[g] > 0)
                    cows++;
                numbers[s]++;
                numbers[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}

