package algorithm.RecursionAndDP;

/**
 * Created by muni on 2019/12/11
 */
public class PaintHouse {
    public static void main(String[] args) {
        System.out.println(new PaintHouse().minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }

    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;

        for (int i=1; i<n; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }

        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }
}
