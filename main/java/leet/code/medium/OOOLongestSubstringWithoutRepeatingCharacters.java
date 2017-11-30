package leet.code.medium;


public class OOOLongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test = "anviaj";
		System.out.println(lengthOfLongestSubstring(test));

	}

	public static int lengthOfLongestSubstring(String s) {
		
		String rst = "";
		
		for(char c : s.toCharArray()){
			
			if(rst.indexOf(c) == -1){
				rst += c;
			}
			
		}
		
		System.out.println(rst);
		
		return rst.length();

        
    }
}
