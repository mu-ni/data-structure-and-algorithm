package oa;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by muni on 2021/2/23
 */
public class ChooseAFlask {
    public static void main(String[] args) {
        int[] orders = new int[]{4,6,6,7};
        int[][] markings = new int[][]{{0,3},{0,5},{0,7},{1,6},{1,8},{1,9},{2,3},{2,5},{2,6}};
        System.out.println(new ChooseAFlask().chooseAFlask(4, orders, 3, 9, markings));
    }

    // satisfy requirements but min waste
    public int chooseAFlask(int numOfOrders, int[] requirements, int flaskTypes, int totalMarks, int[][] markings) {
        List<TreeSet<Integer>> list = new ArrayList<>();
        for (int i=0; i<flaskTypes; i++) {
            list.add(new TreeSet<>());
        }
        for (int[] marking : markings) {
            list.get(marking[0]).add(marking[1]);
        }
        int index = -1;
        int diff = Integer.MAX_VALUE;
        for (int i=0; i<flaskTypes; i++) {
            TreeSet<Integer> ts = list.get(i);
            int curDiff = 0;
            for (int n : requirements) {
                Integer higher = ts.ceiling(n);
                if (higher == null) break;
                curDiff += higher - n;
            }
            if (curDiff < diff) {
                index = 0;
                diff = curDiff;
            }
        }
        return index;
    }
}
