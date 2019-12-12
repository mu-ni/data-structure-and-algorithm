package flag;

/**
 * Created by muni on 2019/12/12
 */
public class Backpack {
    int[] weights = new int[]{2,2,4,6,3};
    int maxWeight = 9;
    int n = 5;
    public static void main(String[] args) {
        Backpack bp = new Backpack();
        System.out.println(bp.backtrack());
        System.out.println(bp.backtrack2());

        System.out.println(bp.dp());
        System.out.println(bp.dp2());

        System.out.println(bp.backtrack3());
        System.out.println(bp.dp3());
    }

    int max;
    public int backtrack() {
        max = Integer.MIN_VALUE;
        helper(0, 0);
        return max;
    }

    public void helper(int i, int weight) {
        if (i == n || weight == maxWeight) {
            max = Math.max(max, weight);
            return;
        }

        helper(i+1, weight);
        if (weight + weights[i] <= maxWeight) {
            helper(i+1, weight + weights[i]);
        }
    }

    public int backtrack2() {
        max = Integer.MIN_VALUE;
        helper2(0, 0, new boolean[n][maxWeight+1]);
        return max;
    }

    public void helper2(int i, int weight, boolean[][] visited) {
        if (i == n || weight == maxWeight) {
            max = Math.max(max, weight);
            return;
        }

        if (visited[i][weight]) return;
        visited[i][weight] = true;

        helper2(i+1, weight, visited);
        if (weight + weights[i] <= maxWeight) {
            helper2(i+1, weight + weights[i], visited);
        }
    }

    public int dp() {
        boolean[][] states = new boolean[n][maxWeight+1];
        states[0][0] = true;
        if (weights[0] <= maxWeight) {
            states[0][weights[0]] = true;
        }

        for (int i=1; i<n; i++) {
            // 不把第i个物品放入背包
            for (int j=0; j<=maxWeight; j++) {
                if (states[i-1][j]) {
                    states[i][j] = states[i-1][j];
                }
            }

            // 把第i个物品放入背包
            for (int j=0; j<=maxWeight - weights[i]; j++) {
                if (states[i-1][j]) {
                    states[i][j + weights[i]] = true;
                }
            }
        }

        for (int j=maxWeight; j>=0; j--) {
            if (states[n-1][j]) return j;
        }
        return -1;
    }

    public int dp2() {
        boolean[] states = new boolean[maxWeight+1];
        states[0] = true;
        if (weights[0] <= maxWeight) {
            states[weights[0]] = true;
        }

        for (int i=1; i<n; i++) {
            for (int j=maxWeight - weights[i]; j>=0; j--) {
                if (states[j]) {
                    states[j + weights[i]] = true;
                }
            }
        }

        for (int i=maxWeight; i>=0; i--) {
            if (states[i]) return i;
        }
        return -1;
    }

    int[] values = {3,4,8,9,6};
    int maxValue;
    public int backtrack3() {
        maxValue = Integer.MIN_VALUE;
        helper3(0,0,0);
        return maxValue;
    }

    public void helper3(int i, int weight, int value) {
        if (i == n || weight == maxWeight) {
            maxValue = Math.max(maxValue, value);
            return;
        }

        helper3(i+1, weight, value);
        if (weight + weights[i] <= maxWeight) {
            helper3(i+1, weight + weights[i], value + values[i]);
        }
    }

    public int dp3() {
        maxValue = Integer.MIN_VALUE;
        int[][] states = new int[n][maxWeight+1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < maxWeight+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weights[0] <= maxWeight) {
            states[0][weights[0]] = values[0];
        }

        for (int i=1; i<n; i++) {
            // 不选择第i个物品
            for (int j=0; j<=maxWeight; j++) {
                if (states[i-1][j] >= 0) {
                    states[i][j] = states[i-1][j];
                }
            }

            // 选择第i个物品
            for (int j=0; j<=maxWeight - weights[i]; j++) {
                if (states[i-1][j] < 0) continue;
                states[i][j+weights[i]] = Math.max(states[i-1][j] + values[i], states[i][j+weights[i]]);
            }
        }

        for (int j=0; j<=maxWeight; j++) {
            maxValue = Math.max(maxValue, states[n-1][j]);
        }
        return maxValue;
    }
}
