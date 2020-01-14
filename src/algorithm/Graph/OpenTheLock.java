package algorithm.Graph;

import java.util.*;

/**
 * Created by muni on 2020/1/14
 */
public class OpenTheLock {
    public static void main(String[] args) {
//        System.out.println(new OpenTheLock().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
//        System.out.println(new OpenTheLock().openLock(new String[]{"8888"}, "0009"));
        System.out.println(new OpenTheLock().openLock(new String[]{"2111","2202","2210","0201","2210"}, "2201"));
    }

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;
        visited.add("0000");

        int step = 0;
        int[] dirs = new int[]{1, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) return step;
                char[] arr = cur.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    for (int dir : dirs) {
                        char c = arr[j];
                        arr[j] = (char)(arr[j] + dir);
                        if (arr[j] < '0') arr[j] = '9';
                        if (arr[j] > '9') arr[j] = '0';
                        String str = new String(arr);
                        if (!visited.contains(str)) {
                            visited.add(str);
                            queue.offer(str);
                        }
                        arr[j] = c;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
