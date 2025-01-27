import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Step 1: Initialize reachability matrix
        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Step 2: Populate the matrix based on direct prerequisites
        for (int[] prereq : prerequisites) {
            reachable[prereq[0]][prereq[1]] = true;
        }

        // Step 3: Use Floyd-Warshall to compute transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    reachable[i][j] = reachable[i][j] || (reachable[i][k] && reachable[k][j]);
                }
            }
        }

        // Step 4: Answer queries
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(reachable[query[0]][query[1]]);
        }

        return ans;
    }
}
