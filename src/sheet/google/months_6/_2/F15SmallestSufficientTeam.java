package sheet.google.months_6._2;

// https://leetcode.com/problems/smallest-sufficient-team/description/


import java.util.*;

public class F15SmallestSufficientTeam {

    public static void main(String[] args) {
        F15SmallestSufficientTeam solution = new F15SmallestSufficientTeam();

        // Test case 1
        String[] req_skills = {"java", "nodejs", "reactjs"};
        List<List<String>> people = Arrays.asList(
                Arrays.asList("java"),
                Arrays.asList("nodejs"),
                Arrays.asList("nodejs", "reactjs")
        );
        System.out.println(Arrays.toString(solution.smallestSufficientTeam(req_skills, people)));
        // Output: [0, 2]

        // Test case 2
        String[] req_skills2 = {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        List<List<String>> people2 = Arrays.asList(
                Arrays.asList("algorithms", "math", "java"),
                Arrays.asList("algorithms", "math", "reactjs"),
                Arrays.asList("java", "csharp", "aws"),
                Arrays.asList("reactjs", "csharp"),
                Arrays.asList("csharp", "math"),
                Arrays.asList("aws", "java")
        );
        System.out.println(Arrays.toString(solution.smallestSufficientTeam(req_skills2, people2)));
        // Output: [0, 2]
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length; // Number of required skills
        int skillCount = 1 << n; // Total skill combinations (2^n)

        // Map skill names to bit indices
        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIndex.put(req_skills[i], i);
        }

        // DP array to store the smallest team for each skill combination
        List<Integer>[] dp = new List[skillCount];
        dp[0] = new ArrayList<>(); // No skills require no team members

        for (int i = 0; i < people.size(); i++) {
            // Calculate the skill mask for the current person
            int personSkills = 0;
            for (String skill : people.get(i)) {
                if (skillIndex.containsKey(skill)) {
                    personSkills |= (1 << skillIndex.get(skill));
                }
            }

            // Update DP array for all existing skill combinations
            for (int mask = skillCount - 1; mask >= 0; mask--) {
                if (dp[mask] == null) continue; // Skip invalid states

                int newMask = mask | personSkills; // Combine skills
                if (dp[newMask] == null || dp[newMask].size() > dp[mask].size() + 1) {
                    dp[newMask] = new ArrayList<>(dp[mask]);
                    dp[newMask].add(i);
                }
            }
        }

        // Return the smallest team for the full skill set
        int fullSkillSet = (1 << n) - 1;
        return dp[fullSkillSet].stream().mapToInt(Integer::intValue).toArray();
    }
}

