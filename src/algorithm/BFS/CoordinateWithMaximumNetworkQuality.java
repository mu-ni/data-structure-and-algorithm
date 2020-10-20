package algorithm.BFS;

import java.util.*;

/**
 * Created by muni on 2020/10/20
 */
public class CoordinateWithMaximumNetworkQuality {
    public static void main(String[] args) {
        int[][] towers = new int[][]{{1,2,5}, {2,1,7}, {3,1,9}};
        System.out.println(Arrays.toString(new CoordinateWithMaximumNetworkQuality().bestCoordinate(towers, 2)));
    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        int n = towers.length;
        Arrays.sort(towers, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int[] rst = new int[]{0, 0};
        int max = 0;
        for (int i=0; i<n; i++) {
            int quality = 0;
            for (int j=0; j<n; j++) {
                int x1 = towers[i][0];
                int y1 = towers[i][1];
                int x2 = towers[j][0];
                int y2 = towers[j][1];
                double d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
                if (d > radius) continue;
                quality += towers[j][2]/(1 + d);
            }
            if (quality > max) {
                max = quality;
                rst = new int[]{towers[i][0], towers[i][1]};
            }
        }
        return rst;
    }
}
