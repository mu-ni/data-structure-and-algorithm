package algorithm.RecursionAndDP;

import java.util.Arrays;

/**
 * Created by muni on 2020/10/19
 */
public class BestTeamWithNoConflicts {
    public static void main(String[] args) {
//        int[] scores = new int[]{1,3,5,10,15};
//        int[] ages = new int[]{1,2,3,4,15};
        int[] scores = new int[]{1,2,3,5};
        int[] ages = new int[]{8,9,10,1};
        System.out.println(new BestTeamWithNoConflicts().bestTeamScore(scores, ages));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] candidates = new int[n][2];
        for (int i=0; i<n; i++) {
            candidates[i][0] = ages[i];
            candidates[i][1] = scores[i];
        }
        // sort by age
        // if age same -> sort by score
        Arrays.sort(candidates, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int[] dp = new int[n];
        dp[0] = candidates[0][1];
        int max = dp[0];
        for (int i=1; i<n; i++) {
            // max score until current candidate
            int curScore = candidates[i][1];
            dp[i] = curScore;
            for (int j=0; j<i; j++) {
                if (candidates[j][1] <= curScore) {
                    dp[i] = Math.max(dp[i], curScore + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
