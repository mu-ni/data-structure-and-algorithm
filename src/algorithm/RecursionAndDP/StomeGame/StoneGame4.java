package algorithm.RecursionAndDP.StomeGame;

/**
 * Created by muni on 2020/10/26
 */
public class StoneGame4 {
    public static void main(String[] args) {
        System.out.println(new StoneGame4().winnerSquareGame(1));
        System.out.println(new StoneGame4().winnerSquareGame(4));
        System.out.println(new StoneGame4().winnerSquareGame(7));
    }

    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j*j<=i; j++) {
                if (!dp[i-j*j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
