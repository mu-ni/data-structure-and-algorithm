package algorithm.TwoPointers;

import java.util.Arrays;

/**
 * Created by muni on 2020/10/27
 */
public class BagOfTokens {
    public static void main(String[] args) {
        System.out.println(new BagOfTokens().bagOfTokensScore(new int[]{100,200,300,400}, 200));
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int res = 0, points = 0, i = 0, j = tokens.length - 1;
        while (i <= j) {
            if (P >= tokens[i]) {
                P -= tokens[i++];
                res = Math.max(res, ++points);
            } else if (points > 0) {
                points--;
                P += tokens[j--];
            } else {
                break;
            }
        }
        return res;
    }
}
