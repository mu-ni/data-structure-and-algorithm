package algorithm.RecursionAndDP;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("(a)())()"));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses2("(a)())()"));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses3("(a)())()"));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses4("(a)())()"));
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

    // backtrack - all solutions
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

    // TLE -> add visited set for optimize
    public List<String> removeInvalidParentheses4(String s) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    set.add(str);
                    found = true;
                }
                for (int j=0; j<str.length(); j++) {
                    if (str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                    String sub = str.substring(0, j) + str.substring(j+1);
                    queue.offer(sub);
                }
            }
            if (found) break;
        }
        return new ArrayList<>(set);
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
