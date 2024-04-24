package sheet.strings;


import java.util.HashMap;
import java.util.Map;

public class S15ConvertRomanToDecimals {
    public static int romanToInt(String s) {
        // Map to store the Roman numerals and their integer values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Traverse the string from the end to the start
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = romanMap.get(c);

            // If the current value is less than the previous value, subtract it
            if (value < prevValue) {
                result -= value;
            } else {
                // Otherwise, add it
                result += value;
                prevValue = value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String roman = "MCMXCIV";
        System.out.println("The integer value of the Roman numeral " + roman + " is " + romanToInt(roman));
    }
}

