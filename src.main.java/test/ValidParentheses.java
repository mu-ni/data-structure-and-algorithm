package test;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "()[]{}";
		System.out.println(isValid(test));
	}

    public static boolean isValid(String s) {
    	
    	Stack<Character> stack = new Stack<Character>();
    	
    	for(char c : s.toCharArray()){
    		if (c == '(')
    			stack.push(')');
    		else if (c == '{')
    			stack.push('}');
    		else if (c == '[')
    			stack.push(']');
    		else if (stack.isEmpty() || stack.pop() != c)
    			return false;
    	}
    	
    	
    	return stack.isEmpty();
        
    }
}
