package algorithm.ArrayAndString;

import java.util.*;

/**
 * Created by muni on 2020/7/3
 */
public class PrisonAfterNDays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrisonAfterNDays().prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 100)));
        // [0,1,0,1,0,0,1,0]
        System.out.println(Arrays.toString(new PrisonAfterNDays().prisonAfterNDays(new int[]{0,1,1,1,0,0,0,0}, 99)));
        // [0,0,1,0,0,1,1,0]
    }
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        map.put(Arrays.toString(cells), 0);
        boolean hasCycle = false;
        int cycleLen = 0;
        for (int i=1; i<=N; i++) {
            cells = next(cells);
            String key = Arrays.toString(cells);
            if (map.containsKey(key)) {
                hasCycle = true;
                cycleLen =  i - map.get(key);
                N -= map.get(key);
                break;
            }
            map.put(key, i);
        }

        if (!hasCycle) return cells;
        N %= cycleLen;
        while (N > 0) {
            cells = next(cells);
            N--;
        }
        return cells;
    }

    private int[] next(int[] cells) {
        int[] next = new int[cells.length];
        for (int i=1; i<cells.length-1; i++) {
            next[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return next;
    }
}
