package algorithm.RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    public static void main(String[] args) {
        System.out.print(generateParenthesis(3));
    }

    static ArrayList<String> rst = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        gen(n, n, "");
        return rst;
    }

    public static void gen(int left, int right, String path) {
        if(left == 0 && right == 0) {
            rst.add(path);
            return;
        }
        if(left > 0) {
            gen(left-1, right, path + "(");
        }
        if(left < right && right > 0) {
            gen(left, right-1, path + ")");
        }
    }
}
