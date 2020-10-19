package algorithm.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by muni on 2020/10/19
 */
public class LexicographicallySmallestString {
    public static void main(String[] args) {
        System.out.println(new LexicographicallySmallestString().findLexSmallestString("5525", 9, 2));
        System.out.println(new LexicographicallySmallestString().findLexSmallestString2("5525", 9, 2));
    }

    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String rst = s;
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(rst) < 0) rst = cur;
            char[] arr = cur.toCharArray();
            for (int i=1; i<arr.length; i+=2) {
                arr[i] = (char) ((arr[i] - '0' + a)%10 + '0');
            }
            String add = new String(arr);
            if (!visited.contains(add)) {
                visited.add(add);
                q.offer(add);
            }
            String rotate = cur.substring(n-b) + cur.substring(0,n-b);
            if (!visited.contains(rotate)) {
                visited.add(rotate);
                q.offer(rotate);
            }
        }
        return rst;
    }

    String rst;
    Set<String> visited;
    public String findLexSmallestString2(String s, int a, int b) {
        rst = s;
        visited = new HashSet<>();
        dfs(s, a, b);
        return rst;
    }

    private void dfs(String s, int a, int b) {
        if (visited.contains(s)) return;
        visited.add(s);
        if (s.compareTo(rst) < 0) rst = s;
        char[] arr = s.toCharArray();
        for (int i=1; i<arr.length; i+=2) {
            arr[i] = (char) ((arr[i] - '0' + a)%10 + '0');
        }
        String add = new String(arr);
        dfs(add, a, b);

        String rotate = s.substring(s.length()-b) + s.substring(0,s.length()-b);
        dfs(rotate, a, b);
    }
}
