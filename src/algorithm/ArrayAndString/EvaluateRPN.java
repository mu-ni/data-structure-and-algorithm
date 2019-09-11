package algorithm.ArrayAndString;

import java.util.Stack;

public class EvaluateRPN {
    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(new EvaluateRPN().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch(s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    stack.push(n2/n1);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
