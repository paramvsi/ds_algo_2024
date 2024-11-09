package sheet.google.gpt_150.day_02;


import java.util.*;

public class D37WordLadder2 {

    public static void main(String[] args) {
        D37WordLadder2 solution = new D37WordLadder2();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println("All shortest transformation sequences:");
        for (List<String> path : solution.findLadders(beginWord, endWord, wordList)) {
            System.out.println(path);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return result;
        }

        // Step 1: Build the all-combinations hash map
        Map<String, List<String>> patternMap = new HashMap<>();
        int wordLen = beginWord.length();

        for (String word : wordSet) {
            for (int i = 0; i < wordLen; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // Step 2: BFS to find the shortest paths and distances
        Map<String, Integer> distances = new HashMap<>();
        Map<String, List<String>> adjList = new HashMap<>();
        bfs(beginWord, endWord, patternMap, distances, adjList);

        // Step 3: Backtrack to collect all paths
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        backtrack(beginWord, endWord, adjList, distances, path, result);

        return result;
    }

    // BFS to build distances map and adjacency list
    private void bfs(String beginWord, String endWord, Map<String, List<String>> patternMap,
                     Map<String, Integer> distances, Map<String, List<String>> adjList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distances.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int currentDistance = distances.get(word);

            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                for (String neighbor : patternMap.getOrDefault(pattern, new ArrayList<>())) {
                    adjList.computeIfAbsent(word, k -> new ArrayList<>()).add(neighbor);
                    if (!distances.containsKey(neighbor)) {
                        distances.put(neighbor, currentDistance + 1);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }

    // Backtracking to find all paths from beginWord to endWord
    private void backtrack(String current, String endWord, Map<String, List<String>> adjList,
                           Map<String, Integer> distances, List<String> path, List<List<String>> result) {
        if (current.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (String neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            if (distances.get(neighbor) == distances.get(current) + 1) { // Ensure we're moving to the next level
                path.add(neighbor);
                backtrack(neighbor, endWord, adjList, distances, path, result);
                path.remove(path.size() - 1); // Backtrack
            }
        }
    }
}

