package algorithm.RecursionAndDP;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("(a)())()"));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses2("(a)())()"));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses3("(a)())()"));
    }

    // bfs - min remove
    public List<String> removeInvalidParentheses(String s) {
        List<String> rst = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;
            for (int i=0; i<size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    rst.add(str);
                    found = true;
                    continue;
                }

                for (int j=0; j<str.length(); j++) {
                    if (str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                    String sub = str.substring(0, j) + str.substring(j+1);
                    if (visited.contains(sub)) continue;
                    queue.add(sub);
                    visited.add(sub);
                }
            }
            if (found) break;
        }

        return rst;
    }

    // bfs - all solutions
    public List<String> removeInvalidParentheses3(String s) {
        List<String> rst = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    rst.add(str);
                    continue;
                }

                for (int j=0; j<str.length(); j++) {
                    if (str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                    String sub = str.substring(0, j) + str.substring(j+1);
                    if (visited.contains(sub)) continue;
                    queue.add(sub);
                    visited.add(sub);
                }
            }
        }

        return rst;
    }

    // dfs - all solutions
    public List<String> removeInvalidParentheses2(String s) {
        List<String> rst = new ArrayList<>();
        dfs(rst, s, new HashSet<>());
        return rst;
    }

    public void dfs(List<String> rst, String s, HashSet<String> visited) {
        if (isValid(s)) {
            rst.add(s);
            return;
        }

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
            String sub = s.substring(0, i) + s.substring(i+1);
            if (visited.contains(sub)) continue;
            visited.add(sub);
            dfs(rst, sub, visited);
        }
    }

    public boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
