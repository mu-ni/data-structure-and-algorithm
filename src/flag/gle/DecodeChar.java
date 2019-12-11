package flag.gle;

import java.util.Stack;

/**
 * Created by muni on 2019/12/11
 *
 * - > 给定一组char，包含({.小括号
 Eg. : a(b(c){2}){2}d will be decompressed as abccbccd.
 {}中间的是前面（）里的内容的重复次数。

 思路: 用栈，所有的往栈里压，直到），开始把上一个（之后的全部弹出到栈外，然后乘以倍数，然后翻转，再重新压到栈里，然后直到最后，全都弹出栈，翻转，就是结果了
 */
public class DecodeChar {
    public static void main(String[] args) {
        System.out.println(new DecodeChar().decode("a(b(cs){11}){3}d"));
    }

    // assume s is valid
    public String decode(String s) {
        Stack<Character> stack = new Stack<>();
        int num = 0;
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '{') {
                while (s.charAt(index+1) != '}') {
                    num = num*10 + s.charAt(index+1) - '0';
                    index++;
                }
            } else if (c == '}') {
                StringBuilder sb = new StringBuilder();
                stack.pop(); // pop ')'
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // pop '('
                String tmp = repeat(sb.reverse().toString(), num);
                for (char t : tmp.toCharArray()) {
                    stack.push(t);
                }
                num = 0;
            } else {
                stack.push(c);
            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String repeat(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
