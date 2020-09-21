package algorithm.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by muni on 2020/9/21
 */
public class SequentialDigits {
    public static void main(String[] args) {
        System.out.println(new SequentialDigits().sequentialDigits(1000, 13000));
        System.out.println(new SequentialDigits().sequentialDigits2(1000, 13000));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> rst = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur >= low && cur <= high) {
                rst.add(cur);
            }
            int num = cur % 10 + 1;
            int next = cur * 10 + num;
            if (num < 10 && next <= high) {
                q.add(next);
            }
        }
        return rst;
    }

    public List<Integer> sequentialDigits2(int low, int high) {
        List<Integer> rst = new ArrayList<>();
        String s = "123456789";
        for (int l = String.valueOf(low).length(); l <= String.valueOf(high).length(); l++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + l > s.length()) continue;
                int n = Integer.parseInt(s.substring(i, i + l));
                if (n >= low && n <= high) rst.add(n);
            }
        }
        return rst;
    }
}
