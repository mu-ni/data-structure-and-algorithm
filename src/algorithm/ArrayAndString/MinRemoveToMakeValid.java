package algorithm.ArrayAndString;

import java.util.*;

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        System.out.println(new MinRemoveToMakeValid().minRemoveToMakeValid("a)b(c)d"));
        System.out.println(new MinRemoveToMakeValid().minRemoveToMakeValid2("a)b(c)d"));
        System.out.println(new MinRemoveToMakeValid().minRemoveToMakeValid3("a)b(c)d"));
        System.out.println(new MinRemoveToMakeValid().minRemoveToMakeValid4("a)b(c)d"));
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

    public String minRemoveToMakeValid3(String s) {
        boolean[] invValid = new boolean[s.length()];

        int left = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    invValid[i] = true;
                }
            }
        }

        int right = 0;
        for (int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c == ')') right++;
            if (c == '(') {
                if (right > 0) {
                    right--;
                } else {
                    invValid[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (invValid[i]) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String minRemoveToMakeValid4(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        for (int i=0; i<arr.length; i++) {
            char c = arr[i];
            if (c == '(') left++;
            if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    arr[i] = '*';
                }
            }
        }

        int right = 0;
        for (int i=arr.length-1; i>=0; i--) {
            char c = arr[i];
            if (c == ')') right++;
            if (c == '(') {
                if (right > 0) {
                    right--;
                } else {
                    arr[i] = '*';
                }
            }
        }

        return new String(arr).replace("*", "");
    }
}
