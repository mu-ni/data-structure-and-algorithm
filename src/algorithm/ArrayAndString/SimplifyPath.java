package algorithm.ArrayAndString;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/a/../../b/../c//.//"));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            }
            if (!s.isEmpty() && !s.equals("..") && !s.equals(".")) {
                stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()).insert(0, "/");
        }
        String rst = sb.toString();
        return rst.isEmpty() ? "/" : rst;
    }
}
