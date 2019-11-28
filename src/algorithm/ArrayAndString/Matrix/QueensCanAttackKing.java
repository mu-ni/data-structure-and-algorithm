package algorithm.ArrayAndString.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensCanAttackKing {

    public static void main(String[] args) {
        int[][] queens = new int[][]{{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        System.out.println(new QueensCanAttackKing().queensAttacktheKing(queens, new int[]{0,0}));
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> rst = new ArrayList<>();
        for (int[] dir : dirs) {
            for (int i=1; i<=8; i++) {
                int x = king[0] + i*dir[0];
                int y = king[1] + i*dir[1];
                if (contains(queens, new int[]{x, y})) {
                    rst.add(Arrays.asList(x, y));
                    break;
                }
            }
        }
        return rst;
    }

    public boolean contains(int[][] queens, int[] pos) {
        for (int[] queen : queens) {
            if (queen[0] == pos[0] && queen[1] == pos[1]) return true;
        }
        return false;
    }
}
