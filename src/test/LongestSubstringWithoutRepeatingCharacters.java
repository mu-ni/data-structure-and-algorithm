package test;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test = "pwwkew";
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(test));

	}

	public int lengthOfLongestSubstring(String s) {		
		Set<Character> set = new HashSet<>();
		int ans = 0;
		int i = 0;
		int j = 0;
		
		while(i<s.length() && j<s.length()) {
			if(set.contains(s.charAt(j))) {
				set.remove(s.charAt(i));
				i++;
			}else {
				set.add(s.charAt(j));
				j++;
				ans = Math.max(ans, j-i);
			}
		}
		
		return ans;
    }
	
}
