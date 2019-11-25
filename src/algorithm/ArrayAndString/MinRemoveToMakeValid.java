package algorithm.ArrayAndString;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        System.out.println(new MinRemoveToMakeValid().minRemoveToMakeValid("))(("));
        System.out.println(new MinRemoveToMakeValid().minRemoveToMakeValid2("))(("));
    }

    // TLE
    public String minRemoveToMakeValid(String s) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (isValid(str)) return str;

            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;
                String sub = str.substring(0, i) + str.substring(i+1);
                if (visited.contains(sub)) continue;
                visited.add(sub);
                queue.offer(sub);
            }
        }
        return "";
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

    public String minRemoveToMakeValid2(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') {
                if (count == 0) continue;
                count--;
            }
            sb.append(c);
        }
        String str = sb.toString();
        if (count == 0) return str;

        sb = new StringBuilder();
        for (int i=str.length()-1; i>=0; i--) {
            if (str.charAt(i) == '(' && count-- > 0) continue;
            sb.append(str.charAt(i));
        }
        return sb.reverse().toString();
    }
}
