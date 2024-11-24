package sheet.google.months_6._2;

//  https://leetcode.com/problems/find-and-replace-in-string


import java.util.Arrays;

public class F20FindAndReplaceInAString {

    public static void main(String[] args) {
        F20FindAndReplaceInAString solution = new F20FindAndReplaceInAString();

        // Test case 1
        String s1 = "abcd";
        int[] indices1 = {0, 2};
        String[] sources1 = {"a", "cd"};
        String[] targets1 = {"eee", "ffff"};
        System.out.println(solution.findReplaceString(s1, indices1, sources1, targets1));
        // Output: "eeebffff"

        // Test case 2
        String s2 = "abcd";
        int[] indices2 = {0, 2};
        String[] sources2 = {"ab", "ec"};
        String[] targets2 = {"eee", "ffff"};
        System.out.println(solution.findReplaceString(s2, indices2, sources2, targets2));
        // Output: "abcd"
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);

        for(int i = 0; i < indices.length; i++){
            if(indices[i] + sources[i].length() <= s.length()
                    && s.startsWith(sources[i], indices[i])){
                match[indices[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < n){
            if(match[idx] != -1){
                sb.append(targets[match[idx]]);
                idx += sources[match[idx]].length();
            }
            else{
                sb.append(s.charAt(idx));
                idx++;
            }
        }

        return sb.toString();
    }
}

