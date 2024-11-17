package sheet.google.practice.strings;


import java.util.*;

public class S08GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray); // Create a string from the sorted char array

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>()); // Initialize the list if this sorted key is not already present
            }
            map.get(sortedString).add(s); // Add the original string to the list corresponding to the sorted key
        }

        return new ArrayList<>(map.values()); // Return a new ArrayList containing all the values of the map
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"}; // Example input
        List<List<String>> grouped = groupAnagrams(strs);
        System.out.println("Grouped anagrams: " + grouped);
    }
}
