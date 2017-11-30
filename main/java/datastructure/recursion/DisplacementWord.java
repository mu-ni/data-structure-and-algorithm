package datastructure.recursion;

public class DisplacementWord {
	
	public static String first;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		anagram("cat".toCharArray(), 0);
	}
	
	private static void swap(char[] word, int i, int j){
		char temp = word[i];
		word[i] = word[j];
		word[j] = temp;
	}
	
	public static void anagram(char[] word, int start){
		if(start == word.length){
			System.out.println(word);
		}else{
			for(int i=start; i<word.length; i++){
				swap(word, i, start);
				anagram(word, start+1);
				swap(word, start, i);
			}
		}
	}
}
