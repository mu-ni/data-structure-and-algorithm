package datastruc.stack;

public class BracketValidate {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "{[(a+b)*c]/d}";
		System.out.println("Init string is: " + str);
		boolean isValid = isValidString(str);
		System.out.println("String is valid? " + isValid);
		
	}
	
	public static boolean isValidString(String str){
		java.util.Stack<Character> stack = new java.util.Stack<>();
		
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			switch(ch){
				case '(':
				case '[':
				case '{':
					stack.push(ch);
					break;
				case ')':
				case ']':
				case '}':
					if(!stack.isEmpty()){
						char peek = stack.peek();
						if(peek == '(' && ch == ')'
							|| peek == '[' && ch == ']'
							|| peek == '{' && ch == '}'){
							stack.pop();
							break;
						}else{
							System.out.println("Error: " + ch + " at index " + i);
							return false;
						}
					}else{
						System.out.println("Error: " + ch + " at index " + i);
						return false;
					}
				default:
					break;
			}
		}
		
		if(!stack.isEmpty()){
			System.out.print("Error: redundant left parenthesis: ");
			while(!stack.isEmpty()){
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
			return false;
		}else{
			return true;
		}
	}
	
	
}
