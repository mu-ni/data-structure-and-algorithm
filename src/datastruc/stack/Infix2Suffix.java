package datastruc.stack;

import java.util.Stack;

public class Infix2Suffix {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println(infix2suffix("F+(A+(B-C))"));
		System.out.println(infix2suffix("A+B*C"));
		System.out.println(infix2suffix("A+B*(C-D+E)"));
	}
	
	public static String infix2suffix(String infixExpression){//do not support () validation
		
		char[] infix = infixExpression.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		String suffix = "";
		
		for(char c: infix){
			switch(String.valueOf(c)){
				case "+":
					if(stack.isEmpty()){
						stack.push(c);
					}else if(String.valueOf(stack.peek()).equals("+") || String.valueOf(stack.peek()).equals("-")){
						suffix += String.valueOf(stack.pop());
						stack.push(c);
					}else if(String.valueOf(stack.peek()).equals("*") || String.valueOf(stack.peek()).equals("/")){
						suffix += String.valueOf(stack.pop());
						stack.push(c);
					}else{//"("
						stack.push(c);
//						suffix += String.valueOf(c);
					}
					break;
				case "-":
					if(stack.isEmpty()){
						stack.push(c);
					}else if(String.valueOf(stack.peek()).equals("+") || String.valueOf(stack.peek()).equals("-")){
						suffix += String.valueOf(stack.pop());
						stack.push(c);
					}else if(String.valueOf(stack.peek()).equals("*") || String.valueOf(stack.peek()).equals("/")){
						suffix += String.valueOf(stack.pop());
						stack.push(c);
					}else{//"("
						stack.push(c);
//						suffix += String.valueOf(c);
					}
					break;
				case "*":
					if(stack.isEmpty()){
						stack.push(c);
					}else if(String.valueOf(stack.peek()).equals("+") || String.valueOf(stack.peek()).equals("-")){
						stack.push(c);
					}else if(String.valueOf(stack.peek()).equals("*") || String.valueOf(stack.peek()).equals("/")){
						suffix += String.valueOf(stack.pop());
						stack.push(c);
					}else{//"("
						stack.push(c);
						suffix += String.valueOf(c);
					}
					break;
				case "/":
					if(stack.isEmpty()){
						stack.push(c);
					}else if(String.valueOf(stack.peek()).equals("+") || String.valueOf(stack.peek()).equals("-")){
						stack.push(c);
					}else if(String.valueOf(stack.peek()).equals("*") || String.valueOf(stack.peek()).equals("/")){
						suffix += String.valueOf(stack.pop());
						stack.push(c);
					}else{//"("
						stack.push(c);
						suffix += String.valueOf(c);
					}
					break;
				case "(":
					stack.push(c);
					break;
				case ")":
					if(stack.isEmpty()){
						return "ERROR";
					}else if(String.valueOf(stack.peek()).equals("+") || String.valueOf(stack.peek()).equals("-")){
						stack.push(c);
					}else if(String.valueOf(stack.peek()).equals("*") || String.valueOf(stack.peek()).equals("/")){
						stack.push(c);
					}else{//"("
						stack.pop();
					}
					break;
				default:
					suffix += String.valueOf(c);
					break;				
			}
		}
		
		while(!stack.isEmpty()){			
			if(!String.valueOf(stack.peek()).equals("(") && !String.valueOf(stack.peek()).equals(")")){
				suffix += stack.pop();
			}else{	
				stack.pop();
			}	
		}
		
		return suffix;
	}
	
}
