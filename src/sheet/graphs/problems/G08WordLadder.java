package sheet.graphs.problems;


import java.util.*;

public class G08WordLadder {
    public static void main(String[] args) {
        G08WordLadder solver = new G08WordLadder();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Ladder Length: " + solver.ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int length = node.getValue();

            if (word.equals(endWord)) {
                return length;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] wordChars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordChars[i] = c;
                    String transformedWord = new String(wordChars);
                    if (wordSet.contains(transformedWord) && !transformedWord.equals(word)) {
                        queue.add(new Pair<>(transformedWord, length + 1));
                        wordSet.remove(transformedWord); // Remove to prevent revisiting
                    }
                }
            }
        }

        return 0;
    }
}

