package algorithm.Greedy;

/**
 * Created by muni on 2019/12/26
 */
public class PlayWithChips {
    public static void main(String[] args) {
        System.out.println(new PlayWithChips().minCostToMoveChips(new int[]{1,2,3}));
    }

    // i-th chip is at position chips[i] -> array item is position
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        for (int pos : chips) {
            if (pos%2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }
}
