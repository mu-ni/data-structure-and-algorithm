package algorithm.RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<>();
        helper(n, n, rst, "");
        return rst;
    }

    public static void helper(int left, int right, List<String> rst, String path) {
        if (left == 0 && right == 0) {
            rst.add(path);
            return;
        }

        if (left > 0) {
            helper(left-1, right, rst, path + "(");
        }
        if (left < right && right > 0) {
            helper(left, right-1, rst, path + ")");
        }
    }
}
