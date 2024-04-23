package sheet.strings;

public class S06SplitBinaryStringIntoEqual0and1 {

    // Method to count how many times the binary string can be split
    // into substrings containing equal number of 0s and 1s.
    public static int maxSplits(String s) {
        int count0 = 0, count1 = 0, splits = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }

            // Increment the splits count each time the counts of 0s and 1s are equal
            if (count0 == count1) {
                splits++;
            }
        }

        return splits;
    }

    public static void main(String[] args) {
        String binaryString = "010101";
        System.out.println("The binary string can be split into " + maxSplits(binaryString) + " substrings with equal numbers of 0s and 1s.");
    }
}


