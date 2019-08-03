package datastruc.stack;

public class WordReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word = "helloworld";
		System.out.println("Init word is: " + word);
		char[] wordArray = word.toCharArray();
		java.util.Stack<Character> stack = new java.util.Stack<>();
		for(char c : wordArray){
			stack.push(c);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(String.valueOf(stack.pop()));
		}		
		
		System.out.println("Reversed word is: " + sb.toString());
	}

}
