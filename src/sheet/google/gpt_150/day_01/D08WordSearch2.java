package sheet.google.gpt_150.day_01;

import java.util.ArrayList;
import java.util.List;

public class D08WordSearch2 {

    public static void main(String[] args) {
        D08WordSearch2 wordSearch = new D08WordSearch2();

        char[][] board1 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words1 = {"oath", "pea", "eat", "rain"};
        System.out.println("Test Case 1: " + wordSearch.findWords(board1, words1));

        char[][] board2 = {
                {'a', 'b'},
                {'c', 'd'}
        };
        String[] words2 = {"abcb"};
        System.out.println("Test Case 2: " + wordSearch.findWords(board2, words2));

        char[][] board3 = {
                {'a', 'a'}
        };
        String[] words3 = {"aa"};
        System.out.println("Test Case 3: " + wordSearch.findWords(board3, words3));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];

        if (c == '#' || node.children[c - 'a'] == null) {
            return; // Already visited or no matching child in Trie
        }

        node = node.children[c - 'a'];

        // If a word is found
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate results
        }

        // Mark the cell as visited
        board[i][j] = '#';

        // Explore all 4 possible directions
        if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);

        // Restore the cell after exploration
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }

            node.word = word; // Store the word in the leaf node
        }

        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

}

