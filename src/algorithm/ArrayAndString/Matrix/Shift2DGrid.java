package algorithm.ArrayAndString.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muni on 2019/12/27
 */
public class Shift2DGrid {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        System.out.println(new Shift2DGrid().shiftGrid(grid, 4));
    }

    // 2d -> 1d
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m*n;
        k = k%len;
        k = len - k;

        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        for (int i=0; i<len; i++) {
            int index = i + k;
            if (index >= len) index %= len;
            line.add(grid[index/n][index%n]);
            if (line.size() == n) {
                rst.add(line);
                line = new ArrayList<>();
            }
        }
        return rst;
    }
}
